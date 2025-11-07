package com.pluralsight;

public abstract class Toppings {
    protected String name;

    public Toppings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double calculatePrice(int sandwichSize);

    @Override
    public String toString() {
        return name;
    }
}
