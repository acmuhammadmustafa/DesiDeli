package com.pluralsight;

public class Meat extends Toppings{
    private boolean extra;

    public Meat(String name, boolean extra) {
        super(name);
        this.extra = extra;
    }


    public double calcPrice(int sandwichSize){
        double basePrice = switch (sandwichSize) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.0;
        };
        if (extra) {
            double extraPrice = switch (sandwichSize) {
                case 4 -> 0.50;
                case 8 -> 1.00;
                case 12 -> 1.50;
                default -> 0.0;
            };
            return basePrice + extraPrice;
        }

        return basePrice;
    }

    @Override
    public double calculatePrice(int sandwichSize) {
        return calcPrice(sandwichSize);
    }

    @Override
    public String toString() {
        return name + (extra ? " (extra)" : "");
    }
}