package com.example.pizzaservice.model;

import java.io.Serializable;

public class Cart implements Serializable {
    CartItem[] cartItems;

    public CartItem[] getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItem[] cartItems) {
        this.cartItems = cartItems;
    }
}
