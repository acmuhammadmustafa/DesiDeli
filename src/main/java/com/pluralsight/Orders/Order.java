package com.pluralsight.Orders;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Order {

    // Variables:
    private final LocalDateTime orderTime;
    private final String receiptFileName;
    private final List<OrderItem> items = new ArrayList<>();
    private static int orderCounter = 0;

    // Constructor:
    public Order() {
        this.orderTime = LocalDateTime.now();
        orderCounter++;
        this.receiptFileName = "receipts/" + orderTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-")) + orderCounter + ".txt";
    }
// Method based on what is being added to order:
    public void addItem(OrderItem orderItem){
        this.items.add((orderItem));
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0; // Total starts at 0 and adds as goes:

        for (OrderItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    public String getReceiptContent() {
        StringBuilder receipt = new StringBuilder("\uD83D\uDCDD━━━━━━━━━━━━━━━━━━━━━━━DESI DELI━━━━━━━━━━━━━━━━━━━━━━━━━━━━\uD83D\uDCDD\n");
        receipt.append("Date: ").append(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");

        // Separate items by type for display
        boolean hasSandwiches = false;
        for (OrderItem item : items) {
            if (item instanceof Sandwich) {
                if (!hasSandwiches) {
                    receipt.append("Sandwiches:\n");
                    hasSandwiches = true;
                }
                receipt.append("  - ").append(item).append("\n");
            }
        }

        boolean hasDrinks = false;
        for (OrderItem item : items) {
            if (item instanceof Drink) {
                if (!hasDrinks) {
                    receipt.append("Drinks:\n");
                    hasDrinks = true;
                }
                receipt.append("  - ").append(item).append("\n");
            }
        }

        boolean hasChips = false;
        for (OrderItem item : items) {
            if (item instanceof Chips) {
                if (!hasChips) {
                    receipt.append("Chips:\n");
                    hasChips = true;
                }
                receipt.append("  - ").append(item).append("\n");
            }
        }

        receipt.append(String.format("\nTotal: $%.2f\n", calculateTotal()));
        receipt.append("\uD83D\uDCDD━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\uD83D\uDCDD\n");
        return receipt.toString();
    }

    public String getReceiptFileName() {
        return receiptFileName;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }



}