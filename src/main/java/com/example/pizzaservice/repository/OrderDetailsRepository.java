package com.example.pizzaservice.repository;

import com.example.pizzaservice.model.Order;
import com.example.pizzaservice.model.OrderDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
    @Query("SELECT od FROM OrderDetails od WHERE od.id = ?1")
    List<OrderDetails> findByODId(Long orderDetailsId);

    List<OrderDetails> findAll();

    @Query("SELECT od FROM OrderDetails od WHERE od.order_id = ?1")
    List<OrderDetails> findByOrderId(Long orderId);

}
