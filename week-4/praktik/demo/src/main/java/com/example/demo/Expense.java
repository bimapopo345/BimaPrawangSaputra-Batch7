package com.example.demo;

public class Expense {
    private String name;
    private double amount;

    // Constructor
    public Expense() {}

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
