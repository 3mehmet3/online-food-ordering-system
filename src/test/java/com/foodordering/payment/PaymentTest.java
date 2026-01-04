package com.foodordering.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testCreditCardPayment() {
        CreditCardPayment payment = new CreditCardPayment("1234567890123456", "Mehmet Karakaş", "12/25");
        assertTrue(payment.processPayment(100.00));
        assertEquals("Credit Card", payment.getPaymentType());
    }

    @Test
    void testCashPaymentSuccess() {
        CashPayment payment = new CashPayment(150.00);
        assertTrue(payment.processPayment(100.00));
    }

    @Test
    void testCashPaymentFail() {
        CashPayment payment = new CashPayment(50.00);
        assertFalse(payment.processPayment(100.00));
    }

    @Test
    void testOnlinePayment() {
        OnlinePayment payment = new OnlinePayment("PayPal", "user@paypal.com");
        assertTrue(payment.processPayment(200.00));
    }
}
