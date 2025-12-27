package com.foodordering.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private List<MenuItem> menu;
    private List<Double> ratings;
    private boolean isOpen;

    public Restaurant(int restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.isOpen = true;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(int itemId) {
        menu.removeIf(item -> item.getId() == itemId);
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  " + name + " - MENÜ");
        System.out.println("╚════════════════════════════════════╝");

        List<String> categories = menu.stream()
                .map(MenuItem::getCategory)
                .distinct()
                .collect(Collectors.toList());

        for (String category : categories) {
            System.out.println("\n--- " + category + " ---");
            menu.stream()
                    .filter(item -> item.getCategory().equals(category) && item.isAvailable())
                    .forEach(System.out::println);
        }
    }

    public void addRating(double rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
        }
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getName() { return name; }
    public List<MenuItem> getMenu() { return new ArrayList<>(menu); }
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }

    public MenuItem getMenuItemById(int id) {
        return menu.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void displayInfo() {
        System.out.println("\n=== Restoran Bilgileri ===");
        System.out.println("İsim: " + name);
        System.out.println("Adres: " + address);
        System.out.println("Puan: ⭐ " + String.format("%.1f", getAverageRating()) + "/5.0");
        System.out.println("Durum: " + (isOpen ? "Açık" : "Kapalı"));
        System.out.println("Menü Öğeleri: " + menu.size());
    }
}