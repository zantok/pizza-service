package com.example.pizzaservice.controllers;

import com.example.pizzaservice.model.User;
import com.example.pizzaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam String name) {
        System.out.println(name);
        return userService.getUser(name);
    }

    @PostMapping("/user")
    public User addUser(@RequestParam String name) {
        if (userService.getUser(name) == null) {
            User newUser = new User();
            newUser.setName(name);
            userService.addUser(newUser);
            return newUser;
        } else {
            return userService.getUser(name);
        }
    }
}
