package com.example.pizzaservice.controllers;

import com.example.pizzaservice.model.Cart;
import com.example.pizzaservice.model.Order;
import com.example.pizzaservice.services.OrderService;
import com.example.pizzaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/shopping-list")
    public void cartCheckout(@RequestParam String name, @RequestBody Cart cart) {
        Order order = orderService.newOrder(userService.getUser(name), cart);
        orderService.createOrderDetails(order, cart);

    }

}
