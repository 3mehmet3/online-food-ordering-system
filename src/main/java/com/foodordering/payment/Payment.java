package com.foodordering.payment;

public abstract class Payment {
    protected String paymentType;
    protected double amount;

    public Payment(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() { return paymentType; }

    public abstract boolean processPayment(double amount);
}