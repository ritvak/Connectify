package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Config.JwtProvider;
import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.UserRepository;
import com.connectify.Connectify_BackEnd.Response.AuthResponse;
import com.connectify.Connectify_BackEnd.Response.LoginRequest;
import com.connectify.Connectify_BackEnd.Service.CustomerUserDetailsService;
import com.connectify.Connectify_BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {
        User isExist=userRepository.findByEmail(user.getEmail());

        if(isExist!=null)
        {
            throw new Exception("user already used with another account");
        }

        User newUser=new User();

        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User saveUser= userRepository.save(newUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(saveUser.getEmail(),saveUser.getPassword());

        String token= JwtProvider.generateToken(authentication);

        AuthResponse authResponse=new AuthResponse(token,"Register Success");

        return authResponse;
    }

    @PostMapping("/signin")
    public AuthResponse signIn(@RequestBody LoginRequest loginRequest)
    {
        Authentication authentication=
                authenticate(loginRequest.getEmail(),loginRequest.getPassword());

        String token= JwtProvider.generateToken(authentication);

        AuthResponse authResponse=new AuthResponse(token,"Login Successful");

        return authResponse;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customerUserDetailsService.loadUserByUsername(email);

        if(userDetails==null)
        {
            throw new BadCredentialsException("Invalid username");
        }

        if(!passwordEncoder.matches(password,userDetails.getPassword()))
        {
            throw new BadCredentialsException("wrong password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}
