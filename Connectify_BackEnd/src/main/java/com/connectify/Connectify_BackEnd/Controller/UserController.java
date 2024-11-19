package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Model.User;
import com.connectify.Connectify_BackEnd.Repository.UserRepository;
import com.connectify.Connectify_BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
     UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users/createUser")
    public User createUser(@RequestBody User user)
    {
        User saveUser= userService.registerUser(user);
        return saveUser;
    }

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



    @PutMapping("/api/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {
        User saveUser=userService.updateUser(user,userId);
        return saveUser;
    }

    @PutMapping("/api/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1,@PathVariable Integer userId2) throws Exception {
        User followUser=userService.followUser(userId1,userId2);
        return followUser;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query)
    {
        List<User> users=userService.searchUser(query);
        return users;
    }
}
