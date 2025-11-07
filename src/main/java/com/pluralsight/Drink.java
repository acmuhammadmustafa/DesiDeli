package com.pluralsight;

public class Drink extends OrderItem{

    private String drinkType;
    private String size;

    public Drink(String drinkType, String size) {
        this.drinkType = drinkType;
        this.size = size;
    }
    private double computeSizePrice(int length) {
        return switch (length) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Drink: " + drinkType +
                "| Size: " + size;
    }
}
