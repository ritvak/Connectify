package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
     UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        User saveUser= userRepository.save(user);
        return saveUser;
    }

    @GetMapping("/allUsers")
    public List<User> getUsers()
    {
        List<User> users=userRepository.findAll();

        return users;
    }


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) throws Exception {
        Optional<User> user=userRepository.findById(userId);

        if(user.isPresent())
        {
            return user.get();
        }
        throw new Exception("user does not exit with userid "+userId);
    }



    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {
        Optional<User> user1=userRepository.findById(userId);

        if(user1.isEmpty())
        {
            throw new Exception("user does not exist with "+userId);
        }
        User oldUser=user1.get();
        if(user.getFirstName()!=null)
        {
            oldUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null)
        {
            oldUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null)
        {
            oldUser.setEmail(user.getEmail());
        }
        User updateUser=userRepository.save(oldUser);

        return updateUser;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws Exception {
        Optional<User> user1=userRepository.findById(userId);

        if(user1.isEmpty())
        {
            throw new Exception("user does not exist with "+userId);
        }
        User oldUser=user1.get();

        userRepository.delete(oldUser);

        return "user deleted successfully with id "+userId;
    }
}
