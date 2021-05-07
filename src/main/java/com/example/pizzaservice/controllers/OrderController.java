package com.example.pizzaservice.controllers;

import com.example.pizzaservice.model.Order;
import com.example.pizzaservice.services.OrderService;
import com.example.pizzaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    @GetMapping("/history")
    public List<Order> getOrderHistory(@RequestParam Long userId) {

        return orderService.getUserOrderHistory(userService.getUserById(userId));
    }
}
