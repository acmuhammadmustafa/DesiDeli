package com.pluralsight;

public abstract class Toppings {
    protected String name;

    public Toppings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculatePrice(int sandwichSize) {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
