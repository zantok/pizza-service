package com.example.pizzaservice.services;

import com.example.pizzaservice.model.Product;
import com.example.pizzaservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProductsByType(String type) {
        return productRepository.getByType(type);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

}
