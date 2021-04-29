package com.example.pizzaservice.controllers;

import com.example.pizzaservice.model.OrderDetails;
import com.example.pizzaservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/history")
    public List<OrderDetails> getOrder(@RequestParam Long orderId){
        return orderService.getOrderDetailsByOrderId(orderId);
    }

//    @PostMapping("/order{name}")
//    public void completeOrder(@PathVariable String name, ){
//
//    }
}
