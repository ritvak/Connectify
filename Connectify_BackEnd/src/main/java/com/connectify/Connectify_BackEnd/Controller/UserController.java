package com.connectify.Connectify_BackEnd.Controller;

import com.connectify.Connectify_BackEnd.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {



    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id)
    {
        User user1=new User(1,"Ritu","Katrodiya","ritva339@gmail.com","Ritva@123");
        user1.setId(id);
        return user1;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        User user2=new User();
        user2.setId(user.getId());
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());

        return user2;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user)
    {
        User user1=new User(1,"Ritu","Katrodiya","ritva339@gmail.com","Ritva@123");

        if(user.getFirstName()!=null)
        {
            user1.setFirstName(user.getFirstName());
        }
        return user1;
    }
}
