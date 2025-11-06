package com.pluralsight;

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

    private void orderScreen() {
        Order currentOrder = new Order();
        int orderCommand;
        do {
            System.out.println();
            System.out.println("====== Order Menu ======");
            String orderMenu = "What would you like to order?\n 1) Add Sandwich\n 2) Add Drink\n 3) Add Chips\n 4) Checkout\n 0) Cancel Order\n=======================\n";
            System.out.println(orderMenu);
            orderCommand = ConsoleHelper.promptForInt("Enter your command");
            switch (orderCommand) {
                case 1 -> addSandwich();
                    System.out.println("======================");
                    break;

                case 2 -> addDrink();
                    System.out.println("======================");
                    break;

                case 3 -> addChips();
                    System.out.println("======================");
                    break;

                case 4 -> checkout();
                    System.out.println("======================");
                    break;

                case 0 -> System.out.println("Order cancelled! Returning to home menu...");
                    return;

                default -> System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("======================");
            }
        } while (true);
    }
}