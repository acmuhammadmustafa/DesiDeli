package com.pluralsight.Orders;

import com.pluralsight.ToppingsPackage.Toppings;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem{
    private String bread;
    private int length;
    private boolean toasted;
    private List<Toppings> toppings;

    public Sandwich(String bread, int length, boolean toasted) {
        this.bread = bread;
        this.length = length;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    private double computeSizePrice() {
        return switch (length) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };
    }
    @Override
    public double getPrice() {
        double total = computeSizePrice();
        for (Toppings topping : toppings) {
            total += topping.calculatePrice(length);
        }

        return total;
    }

    @Override
    public String toString() {
        String toppingsList = ""; // Starts from here onward and checks for toppings.
        if (!toppings.isEmpty()) {
            toppingsList = " | Toppings: "; // Where list begins being built.
            for (int i = 0; i < toppings.size(); i++) {
                toppingsList += toppings.get(i);
                if (i < toppings.size() - 1) {
                    toppingsList += ", "; // Loops through and adds comma's for every topping passed.
                }
            }
        }

        return length + "\" | " + bread + " bread" + // Starts here and is building the ACTUAL sandwich (bread, length, etc.)
                (toasted ? " | Toasted" : "") +
                toppingsList +
                String.format(" | $%.2f", getPrice());
    }
    public List<Toppings> getToppings() {
        return toppings;
    }
}
