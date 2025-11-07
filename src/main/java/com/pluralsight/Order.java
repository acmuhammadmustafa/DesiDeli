package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // Variables:
    private LocalDateTime time;
    private String receipt;
    private List<Sandwich> sandwich = new ArrayList<>();
    private List<Drink> drink = new ArrayList<>();
    private List<Chips> chip = new ArrayList<>();
    private List<OrderItem> items = new ArrayList<>();
    private double price;
    private static int orderCounter = 0;
    // Constructor:
    public Order() {
        this.time = LocalDateTime.now();
        orderCounter++;
        this.receipt = time.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-"))+orderCounter+".txt";
    }
// Method based on what is being added to order:
    public void addSandwich(Sandwich s) { sandwich.add(s); }
    public void addDrink(Drink d) { drink.add(d); }
    public void addChips(Chips c) { chip.add(c); }

    public void addOrderItem(OrderItem orderItem){
        this.items.add((orderItem));
    }



    public double getTotal() {
        double total = 0; // Total starts at 0 and adds as goes:
        for (Sandwich s : sandwich) total += s.getPrice();
        for (Drink d : drink) total += d.getPrice();
        for (Chips c : chip) total += c.getPrice();
        return total;

//        for (OrderItem item : items){
//            total += item.getPrice();
//        }
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


    public String getReceipt(){
        return receipt;}
}