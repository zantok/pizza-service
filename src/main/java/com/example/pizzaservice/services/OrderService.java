package com.example.pizzaservice.services;

import com.example.pizzaservice.model.*;
import com.example.pizzaservice.repository.OrderDetailsRepository;
import com.example.pizzaservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService  {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void updateStatus(Order order,boolean status){
        orderRepository.updateById(order.getId(),status);
    }

    public Order newOrder(User user,Cart cart){
        Order newOrder = new Order();
        newOrder.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        newOrder.setUser(user);
        double orderSum= 0.0;
        for (CartItem item: cart.getCartItems()
             ) {
            orderSum +=item.getCount() * item.getProduct().getPrice();
        }
        newOrder.setPrice(orderSum);
        newOrder.setAccepted(false);
        orderRepository.save(newOrder);
        return newOrder;
    }

    public void createOrderDetails(Order order, Cart cart){
        for (CartItem entry: cart.getCartItems()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(order);
            orderDetails.setPrice(entry.getProduct().getPrice() * entry.getCount());
            orderDetails.setProduct(entry.getProduct());
            orderDetails.setQuantity(entry.getCount());
            orderDetailsRepository.save(orderDetails);
        }
    }

    public List<OrderDetails> getOrderDetails(Long orderId){
        return orderDetailsRepository.findByODId(orderId);
    }

    public List<OrderDetails> getOrderDetailsByOrderId(Long orderId){

        if(orderRepository.findById(orderId).isPresent()){
            System.out.println("Order " + orderRepository.getById(orderId).getId());
            return orderDetailsRepository.findByOrderId( orderRepository.getById(orderId));
        } else {
            return null;
        }
    }

//    public void updateProductCount(OrderDetails orderDetails, int newCount){
//        orderDetailsRepository.updateQuantityById(orderDetails.getId(),newCount);
//    }

//    public void deleteFromOrder(OrderDetails orderDetails){
//        orderDetailsRepository.deleteById(orderDetails.getId());
//    }



}
