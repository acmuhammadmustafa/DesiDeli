package com.pluralsight;

public class Sandwich extends OrderItem{
    private String bread;
    private int length;
    private boolean toasted;
    private double price;

    public Sandwich(String bread, int length, boolean toasted) {
        this.bread = bread;
        this.length = length;
        this.toasted = toasted;
        this.price = computeSizePrice(length);
    }
    private double computeSizePrice(int length) {
        return switch (length) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }
    @Override
    public double getPrice() {
        return price;
    }

    public String toString() {
        return length + " inch " + bread + (toasted ? "| Toasted: " : " ") + String.format("| $%.2f", price);
    }

}
