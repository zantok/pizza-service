package com.example.pizzaservice.repository;

import com.example.pizzaservice.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product getById(Long id);

    @Query("SELECT p from Product p WHERE p.productType = ?1")
    List<Product> getByType(String type);

    List<Product> findAll();

}
