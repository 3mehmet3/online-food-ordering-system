package com.foodordering.payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate) {
        super("Credit Card");
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    private String maskCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    @Override
    public boolean processPayment(double amount) {
        this.amount = amount;
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card: " + cardNumber);
        System.out.println("Amount: " + amount + " TL");
        return true;
    }
}