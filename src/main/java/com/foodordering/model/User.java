package com.foodordering.model;

public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User(int userId, String name, String email, String password, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    protected String getPhoneNumber() { return phoneNumber; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public abstract void displayUserInfo();
}
