package com.example.pizzaservice.controllers;

import com.example.pizzaservice.model.Product;
import com.example.pizzaservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProductsList(@RequestParam String type) {
        return productService.getAllProductsByType(type);
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam Long id) {
        return productService.getProductById(id);
    }
}
