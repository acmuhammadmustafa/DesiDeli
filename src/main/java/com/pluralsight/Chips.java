package com.pluralsight;

public class Chips extends OrderItem{

    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public double getPrice() {
        return  0;
    }

    @Override
    public String toString() {
        return "Chip(s): " + chipType;
    }
}
