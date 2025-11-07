package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime time;
    private String receipt;
    private List<Sandwich> sandwich = new ArrayList<>();
    private List<Drink> drink = new ArrayList<>();
    private List<Chips> chip = new ArrayList<>();
    private double price;

    public Order() {
        this.time = LocalDateTime.now();
        this.receipt = time.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
    }

    public void addSandwich(Sandwich s) { sandwich.add(s); }
    public void addDrink(Drink d) { drink.add(d); }
    public void addChips(Chips c) { chip.add(c); }

    public String getReceipt(){return receipt;}

    public double getTotal() {
        double total = 0; // Total starts at 0 and adds as goes:
        for (Sandwich s : sandwich) total += s.getPrice();
        for (Drink d : drink) total += d.getPrice();
        for (Chips c : chip) total += c.getPrice();
        return total;
    }
    public String printReceipt() {
        String receipt = "===== Receipt =====";
        receipt += "Date: " + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n";
        System.out.println();

        if (!sandwich.isEmpty()) {
            receipt += "Sandwiches:\n";
            for (Sandwich s : sandwich)
                receipt += ": " + s + "\n";
        }

        if (!drink.isEmpty()) {
            receipt += "Drinks:\n";
            for (Drink d : drink)
                receipt += ": " + d + "\n";
        }

        if (!chip.isEmpty()) {
            receipt += "Chips:\n";
            for (Chips c : chip)
                receipt += ": " + c + "\n";
        }

        receipt += String.format("Total: $%.2f%n", getTotal());
        receipt += "==============================\n";
        return receipt;
    }
}