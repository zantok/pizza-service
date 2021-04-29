package com.example.pizzaservice.services;

import com.example.pizzaservice.model.User;
import com.example.pizzaservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public User getUser(String name){
        return userRepository.findByName(name);
    }
}
