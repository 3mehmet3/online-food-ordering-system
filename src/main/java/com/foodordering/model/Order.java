package com.foodordering.model;

import com.foodordering.payment.Payment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double totalAmount;
    private LocalDateTime orderTime;
    private String status;
    private Payment payment;

    public Order(int orderId, Customer customer, List<MenuItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotal();
        this.orderTime = LocalDateTime.now();
        this.status = "Pending";
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public int getOrderId() { return orderId; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void processPayment(Payment payment) {
        this.payment = payment;
        if (payment.processPayment(totalAmount)) {
            System.out.println("✓ Payment successful!");
            setStatus("Preparing");
        } else {
            System.out.println("✗ Payment failed!");
        }
    }

    public void displayOrderSummary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      ORDER SUMMARY #" + orderId + "           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Time: " + orderTime.format(formatter));
        System.out.println("Status: " + status);
        System.out.println("\nItems:");

        for (MenuItem item : items) {
            System.out.println("  • " + item.getName() + " - " + item.getPrice() + " TL");
        }

        System.out.println("\nTotal: " + totalAmount + " TL");

        if (payment != null) {
            System.out.println("Payment: " + payment.getPaymentType());
        }
    }
}