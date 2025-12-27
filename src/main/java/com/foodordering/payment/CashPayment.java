package com.foodordering.payment;

public class CashPayment extends Payment {
    private double cashReceived;
    private double change;

    public CashPayment(double cashReceived) {
        super("Cash");
        this.cashReceived = cashReceived;
    }

    @Override
    public boolean processPayment(double amount) {
        this.amount = amount;
        if (cashReceived >= amount) {
            change = cashReceived - amount;
            System.out.println("Processing Cash Payment...");
            System.out.println("Received: " + cashReceived + " TL");
            System.out.println("Change: " + change + " TL");
            return true;
        }
        System.out.println("Insufficient cash!");
        return false;
    }
}