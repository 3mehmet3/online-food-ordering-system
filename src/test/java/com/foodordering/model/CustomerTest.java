package com.foodordering.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Mehmet Karakaş", "mehmet@email.com",
                "pass123", "05551234567", "İstanbul");
        item1 = new MenuItem(1, "Adana Kebap", "Közde pişmiş", 120.00, "Ana Yemek");
        item2 = new MenuItem(2, "Ayran", "Soğuk ayran", 15.00, "İçecek");
    }

    @Test
    void testCustomerCreation() {
        assertEquals("Mehmet Karakaş", customer.getName());
        assertEquals("mehmet@email.com", customer.getEmail());
        assertEquals("İstanbul", customer.getAddress());
    }

    @Test
    void testAddToCart() {
        customer.addToCart(item1);
        assertEquals(120.00, customer.calculateTotal(), 0.01);
    }

    @Test
    void testCalculateTotal() {
        customer.addToCart(item1);
        customer.addToCart(item2);
        assertEquals(135.00, customer.calculateTotal(), 0.01);
    }

    @Test
    void testRemoveFromCart() {
        customer.addToCart(item1);
        customer.addToCart(item2);
        customer.removeFromCart(item1);
        assertEquals(15.00, customer.calculateTotal(), 0.01);
    }

    @Test
    void testPasswordVerification() {
        assertTrue(customer.verifyPassword("pass123"));
        assertFalse(customer.verifyPassword("wrongpass"));
    }
}