package com.pluralsight;

public class Sauce extends Toppings{

    public Sauce(String name) {
        super(name);
    }

    @Override
    public double calculatePrice(int sandwichSize) {
        return 0.0;
    }
}
