package com.foodordering.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {
    private MenuItem menuItem;

    @BeforeEach
    void setUp() {
        menuItem = new MenuItem(1, "Adana Kebap", "Közde pişmiş acılı kıyma", 120.00, "Ana Yemek");
    }

    @Test
    void testMenuItemCreation() {
        assertEquals(1, menuItem.getId());
        assertEquals("Adana Kebap", menuItem.getName());
        assertEquals(120.00, menuItem.getPrice(), 0.01);
        assertTrue(menuItem.isAvailable());
    }

    @Test
    void testSetAvailable() {
        menuItem.setAvailable(false);
        assertFalse(menuItem.isAvailable());
    }
}