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

    public double getTotal() {
        double total = 0; // Total starts at 0 and adds as goes:
        for (Sandwich s : sandwich) total += s.getPrice();
        for (Drink d : drink) total += d.getPrice();
        for (Chips c : chip) total += c.getPrice();
        return total;
    }
    public void printReceipt() {
        System.out.println("===== Receipt =====");
        System.out.println("Date: " + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println();

        if (!sandwich.isEmpty()) {
            System.out.println("Sandwiches:");
            for (Sandwich s : sandwich)
                System.out.println(": " + s);
            System.out.println();
        }

        if (!drink.isEmpty()) {
            System.out.println("Drinks:");
            for (Drink d : drink)
                System.out.println(": " + d);
            System.out.println();
        }

        if (!chip.isEmpty()) {
            System.out.println("Chips:");
            for (Chips c : chip)
                System.out.println(": " + c);
            System.out.println();
        }

        System.out.printf("Total: $%.2f\n", getTotal());
        System.out.println("==============================");
    }
    public String getReceipt() { return receipt; }

}
