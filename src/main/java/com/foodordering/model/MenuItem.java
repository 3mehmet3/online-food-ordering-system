package com.foodordering.model;

public class MenuItem { private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private boolean available;

    public MenuItem(int id, String name, String description, double price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = true;
}
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("[%d] %s - %.2f TL\n    %s (%s)",
                id, name, price, description, category);
}
}
