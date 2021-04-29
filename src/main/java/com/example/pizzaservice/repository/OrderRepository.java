package com.example.pizzaservice.repository;

import com.example.pizzaservice.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends  CrudRepository<Order, Long> {

    @Query("SELECT o from Order o WHERE o.id = ?1")
    Order getById(Long id);


    List<Order> findAll();

    @Modifying
    @Query("UPDATE Order o SET  o.isAccepted = ?2 WHERE o.id = ?1")
    void updateById(Long id, boolean status);
}
