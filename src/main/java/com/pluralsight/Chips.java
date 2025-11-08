package com.pluralsight;

public class Chips extends OrderItem{

    private String chipType;
    private double price = 1.50;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return chipType + " Chips" + String.format(" | $%.2f", price);
    }
}
