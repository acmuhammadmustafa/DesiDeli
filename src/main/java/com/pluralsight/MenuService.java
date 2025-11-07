package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuService {

    public void homeMenu(){
    System.out.println("=======================");
        System.out.println("Welcome to the Desi Deli!");
        System.out.println("=======================");
        System.out.println();
    int command;
        do {
        System.out.println();
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
        // Home Menu:
        System.out.println("====== Home Menu ======");
        String homeMenu = "What would you like to do?\n 1) New Order\n 0) Exit\n=======================\n";
        System.out.println(homeMenu);
            command = ConsoleHelper.promptForInt("Enter your command");
            switch (command) {
                case 1:
                    orderScreen();
                    System.out.println("======================");

                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("======================");
            }
        } while (true);
    }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
    // Order Menu:

    public void orderScreen() {
        Order currentOrder = new Order();
        int orderCommand;
        do {
            System.out.println();
            System.out.println("====== Order Menu ======");
            String orderMenu = "What would you like to order?\n 1) Add Sandwich\n 2) Add Drink\n 3) Add Chips\n 4) Checkout\n 0) Cancel Order\n=======================\n";
            System.out.println(orderMenu);
            orderCommand = ConsoleHelper.promptForInt("Enter your command");
            switch (orderCommand) {
                case 1:
                    addSandwich(currentOrder);
                    System.out.println("======================");
                    break;

                case 2:
                    addDrink(currentOrder);
                    System.out.println("======================");
                    break;

                case 3:
                    addChips(currentOrder);
                    System.out.println("======================");
                    break;

                case 4:
                    checkout(currentOrder);
                    System.out.println("======================");
                    return;

                case 0:
                    System.out.println("Order cancelled! Returning to home menu...");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("======================");
            }
        } while (true);
    }

    private void saveReceipt(Order order) {
        try {
            FileWriter fw = new FileWriter(order.getReceipt());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.printReceipt() + Math.random()*10000);
            bw.close();

            System.out.println("Receipt saved as: " + order.getReceipt());

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private void checkout(Order order) {
        System.out.println("========= Receipt =========");
        System.out.println(order.getReceipt());
        String confirm = ConsoleHelper.promptForString("Confirm order? (Y/N): ").toLowerCase().trim();

        if (confirm.equals("y") || confirm.equals("yes")) {
            saveReceipt(order);
            System.out.println("Order confirmed and receipt saved...");
        } else {
            System.out.println("Order cancelled. Returning to the order menu...");
        }
    }

    private void addChips(Order order) {
        System.out.println("addChips works");
    }

    private void addDrink(Order order) {
        System.out.println("addDrink works");
    }

    private void addSandwich(Order order) {
        System.out.println("------ Nom Nom Nom ------");
        String bread = ConsoleHelper.promptForString("Choose bread (white, wheat, rye, wrap)").toLowerCase().trim();
        int length = ConsoleHelper.promptForInt("Choose the size (4, 8, or 12)");
        String toastedInput = ConsoleHelper.promptForString("Toasted? (Y/N)").toLowerCase().trim();
        boolean toasted = toastedInput.equals("y") || toastedInput.equals("yes");

        Sandwich s = new Sandwich(bread, length, toasted);
        order.addSandwich(s);
        System.out.println("Sandwich added: " + s);
    }

}