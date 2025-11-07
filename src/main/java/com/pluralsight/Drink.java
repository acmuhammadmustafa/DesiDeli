package com.pluralsight;

public class Drink extends OrderItem{

    private String drinkType;
    private String size;

    public Drink(String drinkType, String size) {
        this.drinkType = drinkType;
        this.size = size;
    }

    public double getPrice() {
        return 0;
    }

}
