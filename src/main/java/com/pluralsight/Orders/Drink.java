package com.pluralsight.Orders;

public class Drink extends OrderItem {
    private String size;
    private String drinkType;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.drinkType = flavor;
        this.price = computeSizePrice(size);
    }

    private double computeSizePrice(String size) {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return size + " " + drinkType + String.format(" | $%.2f", price);
    }
}