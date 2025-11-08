package com.pluralsight;

public class Cheese extends Toppings{
    private boolean extra;

    public Cheese(String name, boolean extra) {
        super(name);
        this.extra = extra;
    }

    @Override
    public double calculatePrice(int sandwichSize) {
        double basePrice = switch (sandwichSize) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0;
        };

        if (extra) {
            double extraPrice = switch (sandwichSize) {
                case 4 -> 0.30;
                case 8 -> 0.60;
                case 12 -> 0.90;
                default -> 0;
            };
            return basePrice + extraPrice;
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return name + (extra ? " (extra)" : "");
    }
}