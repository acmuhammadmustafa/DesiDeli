package com.pluralsight;

import java.io.*;
import java.util.*;

public class MenuService {

    public void displayHomeScreen() {
        System.out.println("""
🥪━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥪
             WELCOME TO THE DESI DELI
🥪━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥪
""");
        System.out.println();
        int command;
        do {
// Home Menu:
            System.out.println("""
🥖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥖
                       HOME MENU
🥖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥖
""");
            String homeMenu = "What would you like to do?\n 1) New Order\n 0) Exit\n🥖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥖\n";
            System.out.println(homeMenu);
            command = ConsoleHelper.promptForInt("Enter your command");
            switch (command) {
                case 1:
                    orderScreen();
                    System.out.println("🥖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥖");
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("🥖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🥖");
            }
        } while (true);
    } // Finished!

    public void orderScreen() {
        Order currentOrder = new Order();
        int orderCommand;
        do {
            System.out.println();
            System.out.println("""
🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯
                       ORDER MENU
🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯
""");
            String orderMenu = "What would you like to order?\n 1) Add Sandwich\n 2) Add Drink\n 3) Add Chips\n 4) Checkout\n 0) Cancel Order\n🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯\n";
            System.out.println(orderMenu);
            orderCommand = ConsoleHelper.promptForInt("Enter your command");
            switch (orderCommand) {
                case 1:
                    addSandwich(currentOrder);
                    System.out.println("🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯");
                    break;

                case 2:
                    addDrink(currentOrder);
                    System.out.println("🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯");
                    break;

                case 3:
                    addChips(currentOrder);
                    System.out.println("🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯");
                    break;

                case 4:
                    checkout(currentOrder);
                    System.out.println("🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯");
                    return;

                case 0:
                    System.out.println("Order cancelled! Returning to home menu...");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯");
            }
        } while (true);
    } // Finished!

    private void saveReceiptToFileAndFolder(Order order) {
        try {
            FileWriter fw = new FileWriter(order.getReceiptFileName());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.getReceiptContent());
            bw.close();

            System.out.println("Receipt saved as: " + order.getReceiptFileName());

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    } // Finished!

    private void checkout(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your order is empty! Please add items before checking out.");
            return;
        }

        System.out.println("""
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
         🛒  FINAL STOP  🛒
   Would you like to add anything else?
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
""");
        System.out.println(order.getReceiptContent());

        boolean confirm = ConsoleHelper.promptForYesNo("Confirm order?");

        if (confirm) {
            saveReceiptToFileAndFolder(order);
            System.out.println("Order confirmed! Thank you for your purchase.");
        } else {
            System.out.println("Order cancelled. Returning to the order menu...");
        }
    }

    private void addChips(Order order) {
        System.out.println("""
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
           🧂  CHIP STOP  🧂
   Crunchy, crispy, and full of flavor!
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
""");

        List<String> chipList = Arrays.asList("bbq", "plain", "sour cream", "salt & vinegar", "cheddar");
        String type;

        while (true) {
            type = ConsoleHelper.promptForString("Choose chip type (BBQ, Plain, Sour Cream, Salt & Vinegar, Cheddar)").toLowerCase().trim();
            if (chipList.contains(type)) {
                break;
            } else {
                System.out.println("Invalid chip type. Please choose from the options listed.");
            }
        }
        Chips chips = new Chips(type);
        order.addItem(chips);
        System.out.println("Chips added: " + chips);
    }

    private void addDrink(Order order) {
        System.out.println("""
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
        🥤  QUENCH YOUR THIRST  🥤
      Time for something refreshing!
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
""");
        // Drink sizes
        List<String> sizeList = Arrays.asList("small", "medium", "large");
        String size;

        while (true) {
            size = ConsoleHelper.promptForString("Choose size (Small, Medium, Large)").toLowerCase().trim();
            if (sizeList.contains(size)) {
                break;
            } else {
                System.out.println("Invalid size. Please enter Small, Medium, or Large.");
            }
        }

        List<String> flavorList = Arrays.asList("soda", "water", "juice");
        String flavor;

        while (true) {
            flavor = ConsoleHelper.promptForString("Choose beverage (Juice, Water, or Soda)").trim().toLowerCase();

            if (flavorList.contains(flavor)) {
                break;
            } else {
                System.out.println("Invalid beverage. Please enter Juice, Water, or Soda.");
            }
        }

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
        System.out.println("Drink added: " + drink);
    }

    private void addSandwich(Order order) {
        System.out.println("""
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
      🌯  DESI SANDWICH BUILDER  🌯
   Let's make a sandwich worthy of your hunger!
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
""");
        // Breads
        List<String> breadList = Arrays.asList("white", "wheat", "rye", "wrap");
        String bread;

        while (true) {
            bread = ConsoleHelper.promptForString("Choose bread (White, Wheat, Rye, or Wrap)").toLowerCase().trim();
            if (breadList.contains(bread)) {
                break;
            } else {
                System.out.println("Invalid bread type. Please choose from the options listed.");
            }
        }

        // Sizes
        List<Integer> sizeList = Arrays.asList(4, 8, 12);
        int length;

        while (true) {
            length = ConsoleHelper.promptForInt("Choose the size (4, 8, or 12)");
            if (sizeList.contains(length)) {
                break;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }

        Sandwich sandwich = new Sandwich(bread, length, false);

        //Meats
        List<String> meatList = Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon");
        boolean addMeat = ConsoleHelper.promptForYesNo("Add meat?");

        while (addMeat) {
            String meatType;

            while (true) {
                meatType = ConsoleHelper.promptForString("Choose meat (Steak, Ham, Salami, Roast Beef, Chicken, or Bacon)").toLowerCase().trim();
                if (meatList.contains(meatType)) {
                    break;
                }
                System.out.println("Invalid meat type. Please choose from the options listed.");
            }

            boolean extra = ConsoleHelper.promptForYesNo("Extra meat?");
            sandwich.addTopping(new Meat(meatType, extra));

            addMeat = ConsoleHelper.promptForYesNo("Add another meat?");
        }

        // Cheeses
        List<String> cheeseList = Arrays.asList("american", "provolone", "cheddar", "swiss");
        boolean addCheese = ConsoleHelper.promptForYesNo("Add cheese?");

        while (addCheese) {
            String cheeseType;

            while (true) {
                cheeseType = ConsoleHelper.promptForString("Choose cheese (American, Provolone, Cheddar, or Swiss)").toLowerCase().trim();
                if (cheeseList.contains(cheeseType)) {
                    break;
                }
                System.out.println("Invalid cheese type. Please choose from the options listed.");
            }

            boolean extra = ConsoleHelper.promptForYesNo("Extra cheese?");
            sandwich.addTopping(new Cheese(cheeseType, extra));

            addCheese = ConsoleHelper.promptForYesNo("Add another cheese?");
        }

        // Toppings
        List<String> toppingsList = Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms");
        boolean addRegular = ConsoleHelper.promptForYesNo("Add regular toppings?");

        while (addRegular) {
            String toppingType;

            while (true) {
                toppingType = ConsoleHelper.promptForString("Choose topping (Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumbers, Pickles, Guacamole, or Mushrooms)").toLowerCase().trim();
                if (toppingsList.contains(toppingType)) {
                    break;
                } else {
                    System.out.println("Invalid topping. Please choose from the options listed.");
                }
            }
            sandwich.addTopping(new Toppings(toppingType) {
            });
            addRegular = ConsoleHelper.promptForYesNo("Add another topping?");
        }

        // Sauces
        List<String> sauceList = Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette");
        boolean addSauce = ConsoleHelper.promptForYesNo("Add sauce?");

        while (addSauce) {
            String sauceType;

            while (true) {
                sauceType = ConsoleHelper.promptForString("Choose sauce (Mayo, Mustard, Ketchup, Ranch, Thousand Islands, or Vinaigrette)").toLowerCase().trim();
                if (sauceList.contains(sauceType)) {
                    break;
                } else {
                    System.out.println("Invalid sauce. Please choose from the options listed.");
                }
            }
            sandwich.addTopping(new Toppings(sauceType){});
            addSauce = ConsoleHelper.promptForYesNo("Add another sauce?");
        }

        // Toasted?
        boolean toasted = ConsoleHelper.promptForYesNo("Would you like it toasted?");

        if (toasted) {
            Sandwich toastedSandwich = new Sandwich(bread, length, true);
            for (Toppings t : sandwich.getToppings()) {
                toastedSandwich.addTopping(t);
            }
            sandwich = toastedSandwich;
        }

        order.addItem(sandwich);
        System.out.println("Sandwich added: " + sandwich);
    }
}