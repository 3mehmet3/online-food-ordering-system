package com.foodordering.model;

import com.foodordering.interfaces.Orderable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements Orderable {
    private String address;
    private List<Order> orderHistory;
    private List<MenuItem> cart;

    public Customer(int userId, String name, String email, String password,
                    String phoneNumber, String address) {
        super(userId, name, email, password, phoneNumber);
        this.address = address;
        this.orderHistory = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<Order> getOrderHistory() { return new ArrayList<>(orderHistory); }

    @Override
    public void displayUserInfo() {
        System.out.println("=== Customer Information ===");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + address);
        System.out.println("Total Orders: " + orderHistory.size());
    }

    @Override
    public void addToCart(MenuItem item) {
        if (item.isAvailable()) {
            cart.add(item);
            System.out.println("✓ " + item.getName() + " added to cart!");
        } else {
            System.out.println("✗ Sorry, " + item.getName() + " is not available.");
        }
    }

    @Override
    public void removeFromCart(MenuItem item) {
        if (cart.remove(item)) {
            System.out.println("✓ " + item.getName() + " removed from cart.");
        } else {
            System.out.println("✗ Item not found in cart.");
        }
    }

    @Override
    public double calculateTotal() {
        return cart.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("✗ Your cart is empty!");
            return;
        }

        Order order = new Order(orderHistory.size() + 1, this, new ArrayList<>(cart));
        orderHistory.add(order);
        System.out.println("\n✓ Order placed successfully!");
        order.displayOrderSummary();
        cart.clear();
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n=== Your Cart ===");
        for (MenuItem item : cart) {
            System.out.println("• " + item.getName() + " - " + item.getPrice() + " TL");
        }
        System.out.println("Total: " + calculateTotal() + " TL");
    }

    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("You have no previous orders.");
            return;
        }

        System.out.println("\n=== Order History ===");
        for (Order order : orderHistory) {
            order.displayOrderSummary();
            System.out.println("---");
        }
    }
}