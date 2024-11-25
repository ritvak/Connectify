package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.PostRepository;
import com.connectify.Connectify_BackEnd.Repository.UserRepository;
import com.connectify.Connectify_BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;



    @GetMapping("/api/users/allUsers")
    public List<User> getUsers()
    {
        List<User> users=userRepository.findAll();

        return users;
    }


    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable Integer userId) throws Exception {
        User user=userService.findUserById(userId);
       return user;
    }



    @PutMapping("/api/users")
    public User updateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user) throws Exception {
       User reqUser=userService.findUserByJwt(jwt);
        User saveUser=userService.updateUser(user, reqUser.getId());
        return saveUser;
    }

    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer userId2) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        User followUser=userService.followUser(reqUser.getId(), userId2);
        return followUser;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query)
    {
        List<User> users=userService.searchUser(query);
        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt)
    {
        User user =userService.findUserByJwt(jwt);

        user.setPassword(null);
        return user;
    }
}
