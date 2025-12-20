package com.foodordering.interfaces;

import com.foodordering.model.MenuItem;

public interface Orderable {
    void addToCart(MenuItem item);
    void removeFromCart(MenuItem item);
    void placeOrder();
    double calculateTotal();
}