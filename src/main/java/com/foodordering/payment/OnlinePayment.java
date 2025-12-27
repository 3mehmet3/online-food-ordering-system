package com.foodordering.payment;

public class OnlinePayment extends Payment {
    private String walletProvider;
    private String walletId;

    public OnlinePayment(String walletProvider, String walletId) {
        super("Online Payment");
        this.walletProvider = walletProvider;
        this.walletId = walletId;
    }

    @Override
    public boolean processPayment(double amount) {
        this.amount = amount;
        System.out.println("Processing " + walletProvider + " Payment...");
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Amount: " + amount + " TL");
        return true;
    }
}