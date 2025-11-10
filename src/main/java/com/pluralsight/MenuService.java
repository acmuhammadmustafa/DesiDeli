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
    }

    public void orderScreen() {
        Order currentOrder = new Order();
        int orderCommand;
        do {
            System.out.println();
            System.out.println("""
🌯━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌯
                       ORDER MENU
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
    }

    private void addSandwich(Order order) {
        System.out.println("""
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
      🌯  DESI SANDWICH BUILDER  🌯
   Let's make a sandwich worthy of your hunger!
""");
        // Breads
        List<Integer> breadList = Arrays.asList(1,2,3,4);
        System.out.println("Bread list:\n 1) White\n 2) Wheat\n 3) Rye\n 4) Wrap\n");
        String bread;
        int customerBreadChoice;

        while (true) {
            customerBreadChoice = ConsoleHelper.promptForInt("Choose bread");

            if (breadList.contains(customerBreadChoice)) {
                break;
            } else {
                System.out.println("Invalid bread type. Please choose from the options listed.");
            }
        }
        bread = switch (customerBreadChoice) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "Error";
        };
        System.out.println();

        // Bread Sizes
        List<Integer> sizeList = Arrays.asList(1, 2, 3);
        System.out.println("Bread sizes (in inches):\n1) 4 inches\n2) 8 inches\n3) 12 inches");
        int length;
        int customerSizeChoice;

        while (true) {
            customerSizeChoice = ConsoleHelper.promptForInt("Choose size");
            if (sizeList.contains(customerSizeChoice)) {
                break;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }
        length = switch (customerSizeChoice) {
            case 1 -> 4;
            case 2 -> 8;
            case 3 -> 12;
            default -> 0;
        };
        Sandwich sandwich = new Sandwich(bread, length, false);

        //Meats
        List<Integer> meatList = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean addMeat = ConsoleHelper.promptForYesNo("Add meat?");

        while (addMeat) {
            String meatType;
            int customerMeatChoice;
            System.out.println("Meat options:\n 1) Steak\n 2) Ham\n 3) Salami\n 4) Roast Beef\n 5) Chicken\n 6) Bacon\n");
            while (true) {
                customerMeatChoice = ConsoleHelper.promptForInt("Choose meat");
                if (meatList.contains(customerMeatChoice)) {
                    break;
                }
                System.out.println("Invalid meat type. Please choose from the options listed.");
            }
            meatType = switch (customerBreadChoice) {
            case 1 -> "Steak";
            case 2 -> "Ham";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            case 6 -> "Bacon";
            default -> "Error";
        };
            boolean extra = ConsoleHelper.promptForYesNo("Extra/Double meat?");
            sandwich.addTopping(new Meat(meatType, extra));

            addMeat = ConsoleHelper.promptForYesNo("Add another meat?");
        }

        // Cheeses
        List<Integer> cheeseList = Arrays.asList(1, 2, 3, 4);
        boolean addCheese = ConsoleHelper.promptForYesNo("Add cheese?");

        while (addCheese) {
            String cheeseType;
            int customerCheeseChoice;

            while (true) {
                System.out.println("Meat options:\n 1) American\n 2) Provolone\n 3) Cheddar\n 4) Swiss\n");
                customerCheeseChoice = ConsoleHelper.promptForInt("Choose cheese");
                if (cheeseList.contains(customerCheeseChoice)) {
                    break;
                }
                System.out.println("Invalid cheese type. Please choose from the options listed.");
            }
            cheeseType = switch (customerBreadChoice) {
                case 1 -> "American";
                case 2 -> "Provolone";
                case 3 -> "Cheddar";
                case 4 -> "Swiss";
                default -> "Error";
            };
            boolean extra = ConsoleHelper.promptForYesNo("Extra cheese?");
            sandwich.addTopping(new Cheese(cheeseType, extra));

            addCheese = ConsoleHelper.promptForYesNo("Add another cheese?");
        }

        // Toppings
        List<Integer> toppingsList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean addRegular = ConsoleHelper.promptForYesNo("Add regular toppings?");

        while (addRegular) {
            System.out.println("Regular topping options:\n1) Lettuce\n2) Peppers\n3) Onions\n4) Tomatoes\n5) Jalapeños\n6) Cucumbers\n7) Pickles\n8) Guacamole\n9) Mushrooms");
            String toppingType;
            int customerTopping;

            while (true) {
                customerTopping = ConsoleHelper.promptForInt("Choose topping");
                if (toppingsList.contains(customerTopping)) {
                    break;
                } else {
                    System.out.println("Invalid topping. Please choose from the options listed.");
                }
            }
            toppingType = switch (customerBreadChoice) {
                case 1 -> "Lettuce";
                case 2 -> "Peppers";
                case 3 -> "Onions";
                case 4 -> "Tomatoes";
                case 5 -> "Jalapeños";
                case 6 -> "Cucumbers";
                case 7 -> "Pickles";
                case 8 -> "Guacamole";
                case 9 -> "Mushrooms";
                default -> "Error";
            };
            sandwich.addTopping(new Toppings(toppingType) {
            });
            addRegular = ConsoleHelper.promptForYesNo("Add another topping?");
        }

        // Sauces
        List<Integer> sauceList = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean addSauce = ConsoleHelper.promptForYesNo("Add sauce?");

        while (addSauce) {
            System.out.println("Sauce options:\n1) Mayo\n2) Mustard\n3) Ketchup\n4) Ranch\n5) Thousand Islands\n6) Vinaigrette");
            String sauceType;
            int customerSauce;

            while (true) {
                customerSauce = ConsoleHelper.promptForInt("Choose sauce (Mayo, Mustard, Ketchup, Ranch, Thousand Islands, or Vinaigrette)");
                if (sauceList.contains(customerSauce)) {
                    break;
                } else {
                    System.out.println("Invalid sauce. Please choose from the options listed.");
                }
            }
            sauceType = switch (customerSauce) {
                case 1 -> "Mayo";
                case 2 -> "Mustard";
                case 3 -> "Ketchup";
                case 4 -> "Ranch";
                case 5 -> "Thousand Islands";
                case 6 -> "Vinaigrette";
                default -> "Error";
            };
            sandwich.addTopping(new Sauce(sauceType));
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
        System.out.println("🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓");
    }

    private void addChips(Order order) {
        System.out.println("""
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
           🧂  CHIP STOP  🧂
   Crunchy, crispy, and full of flavor!
""");

        List<Integer> chipList = Arrays.asList(1, 2, 3, 4, 5);
        String type = null;
        int customerChip;

        while (true) {
            System.out.println("1) BBQ\n2) Plain\n3) Sour Cream\n4) Salt & Vinegar\n5) Cheddar");
            customerChip = ConsoleHelper.promptForInt("Choose chip type");
            if (chipList.contains(customerChip)) {
                break;
            } else {
                System.out.println("Invalid chip type. Please choose from the options listed.");
            }
            type = switch (customerChip) {
                case 1 -> "BBQ";
                case 2 -> "Plain";
                case 3 -> "Sour Cream";
                case 4 -> "Salt & Vinegar";
                case 5 -> "Cheddar";
                default -> type;
            };
        }
        Chips chips = new Chips(type);
        order.addItem(chips);
        System.out.println("Chips added: " + chips);
        System.out.println("🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟");
    }

    private void addDrink(Order order) {
        System.out.println("""
🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓
        🥤  QUENCH YOUR THIRST  🥤
      Time for something refreshing!
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
        System.out.println("🫓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🫓");
    }

    private void checkout(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your order is empty! Please add items before checking out.");
            return;
        }

        System.out.println("""
🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟
         🛒  FINAL STOP  🛒
   Would you like to add anything else?
""");
        System.out.println(order.getReceiptContent());

        boolean confirm = ConsoleHelper.promptForYesNo("Confirm order?");

        if (confirm) {
            saveReceiptToFileAndFolder(order);
            System.out.println("Order confirmed! Thank you for your purchase.");
        } else {
            System.out.println("Order cancelled. Returning to the order menu...");
        }
        System.out.println("🍟━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🍟");
    }

    private void saveReceiptToFileAndFolder(Order order) {
        try {
            FileWriter fw = new FileWriter(order.getReceiptFileName()); // Makes the receipt text file.
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.getReceiptContent()); // Displays the file's context in checkout.
            bw.close();

            System.out.println("Receipt saved as: " + order.getReceiptFileName()); // Prints it into the checkout program.

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

}