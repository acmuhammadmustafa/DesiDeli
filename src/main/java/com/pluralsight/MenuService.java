package com.pluralsight;

import java.io.*;
import java.util.*;

public class MenuService {

    public void displayHomeScreen() {
        System.out.println("""
╒═════════════════════════════════════════════════════╕
          🥪  WELCOME TO THE DESI DELI 🥪
╘═════════════════════════════════════════════════════╛
""");
        System.out.println();
        int command;
        do {
        // Home Menu:
            System.out.println("""
              ╒═════════════════════════╕
                    🥖 HOME MENU 🥖
              ╘═════════════════════════╛
""");
            String homeMenu = "What would you like to do?\n 1) New Order\n 0) Exit\n『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』\n";
            System.out.println(homeMenu);
            command = ConsoleHelper.promptForInt("Enter your command");
            switch (command) {
                case 1:
                    orderScreen();
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
            }
        } while (true);
    }

    public void orderScreen() {
        Order currentOrder = new Order();
        int orderCommand;
        do {
            System.out.println();
            System.out.println("""
               ╒═══════════════════════════╕
                      🌯ORDER MENU 🌯
               ╘═══════════════════════════╛
""");
            String orderMenu = "What would you like to order?\n 1) Add Sandwich\n 2) Add Drink\n 3) Add Chips\n 4) Add Signature Sandwich\n 5) Checkout\n 0) Cancel Order\n『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』\n";
            System.out.println(orderMenu);
            orderCommand = ConsoleHelper.promptForInt("Enter your command");
            switch (orderCommand) {
                case 1:
                    addSandwich(currentOrder);
                    System.out.println();
                    break;

                case 2:
                    addDrink(currentOrder);
                    System.out.println();
                    break;

                case 3:
                    addChips(currentOrder);
                    System.out.println();
                    break;

                case 4:
                    addSignatureSandwich(currentOrder);
                    System.out.println();
                    break;

                case 5:
                    if(checkout(currentOrder)){
                        System.out.println();
                        return;
                    }
                    else{
                        System.out.println();
                        break;
                    }


                case 0:
                    System.out.println("Order cancelled! Returning to home menu...");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println();
            }
        } while (true);
    }

    private void addSandwich(Order order) {
        System.out.println("""
  ╒══════════════════════════════════════════════╕
          🌯  DESI SANDWICH BUILDER  🌯
    Let's make a sandwich worthy of your hunger!
  ╘══════════════════════════════════════════════╛
""");
        // Bread Type
        List<Integer> breadList = Arrays.asList(1,2,3,4,0);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        System.out.println("Bread list:\n 1) White\n 2) Wheat\n 3) Rye\n 4) Wrap\n 0) Back to Order Menu");
        int customerBreadChoice;

        while (true) {
            customerBreadChoice = ConsoleHelper.promptForInt("Choose bread");
            if (breadList.contains(customerBreadChoice)) {
                if (customerBreadChoice == 0) {
                    System.out.println("Returning to Order Menu...");
                    System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
                    return;
                }
                break;
            } else {
                System.out.println("Invalid chip type. Please choose from the options listed.");
            }
        }
       String bread = switch (customerBreadChoice) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "Error";
        };
        System.out.println();

        // Bread Sizes
        List<Integer> sizeList = Arrays.asList(1, 2, 3);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        System.out.println("Bread sizes (in inches):\n1) 4 inches\n2) 8 inches\n3) 12 inches\n");
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
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        boolean addMeat = ConsoleHelper.promptForYesNo("Add meat?");

        while (addMeat) {
            System.out.println();
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
            System.out.println();
            boolean extra = ConsoleHelper.promptForYesNo("Extra/Double meat?");
            sandwich.addTopping(new Meat(meatType, extra));

            System.out.println();
            addMeat = ConsoleHelper.promptForYesNo("Add another meat?");
        }

        // Cheeses
        List<Integer> cheeseList = Arrays.asList(1, 2, 3, 4);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        boolean addCheese = ConsoleHelper.promptForYesNo("Add cheese?");

        while (addCheese) {
            String cheeseType;
            int customerCheeseChoice;

            while (true) {
                System.out.println();
                System.out.println("Cheese options:\n 1) American\n 2) Provolone\n 3) Cheddar\n 4) Swiss\n");
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
            System.out.println();
            boolean extra = ConsoleHelper.promptForYesNo("Extra cheese?");
            sandwich.addTopping(new Cheese(cheeseType, extra));
            System.out.println();
            addCheese = ConsoleHelper.promptForYesNo("Add another cheese?");
        }

        // Toppings
        List<Integer> toppingsList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        boolean addRegular = ConsoleHelper.promptForYesNo("Add regular toppings?");

        while (addRegular) {
            System.out.println("Regular topping options:\n1) Lettuce\n2) Peppers\n3) Onions\n4) Tomatoes\n5) Jalapeños\n6) Cucumbers\n7) Pickles\n8) Guacamole\n9) Mushrooms\n");
            String toppingType;
            int customerTopping;

            while (true) {
                System.out.println();
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
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        boolean addSauce = ConsoleHelper.promptForYesNo("Add sauce?");

        while (addSauce) {
            System.out.println("Sauce options:\n1) Mayo\n2) Mustard\n3) Ketchup\n4) Ranch\n5) Thousand Islands\n6) Vinaigrette\n");
            String sauceType;
            int customerSauce;

            while (true) {
                System.out.println();
                customerSauce = ConsoleHelper.promptForInt("Choose sauce");
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
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println();
        boolean toasted = ConsoleHelper.promptForYesNo("Would you like it toasted?");

        if (toasted) {
            //sandwich.setToasted();
            Sandwich toastedSandwich = new Sandwich(bread, length, true);
            for (Toppings t : sandwich.getToppings()) {
                toastedSandwich.addTopping(t);
            }
            sandwich = toastedSandwich;
        }

        order.addItem(sandwich);
        System.out.println("Sandwich added: " + sandwich);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void addChips(Order order) {
        System.out.println("""
    ╒═════════════════════════════════════════╕
                 🧂  CHIP STOP  🧂
        Crunchy, crispy, and full of flavor!
    ╘═════════════════════════════════════════╛
""");

        List<Integer> chipList = Arrays.asList(1, 2, 3, 4, 5,0);
        int customerChip;

        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");

        while (true) {
            System.out.println("1) BBQ\n2) Plain\n3) Sour Cream\n4) Salt & Vinegar\n5) Cheddar\n0) Return to Order Menu");
            customerChip = ConsoleHelper.promptForInt("Choose chip type");
            if (chipList.contains(customerChip)) {
                if (customerChip == 0) {
                    System.out.println("Returning to Order Menu...");
                    System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
                    return;
                }
                break;
            } else {
                System.out.println("Invalid chip type. Please choose from the options listed.");
                System.out.println();
            }
        }
        String type = switch (customerChip) {
            case 1 -> "BBQ";
            case 2 -> "Plain";
            case 3 -> "Sour Cream";
            case 4 -> "Salt & Vinegar";
            case 5 -> "Cheddar";
            default -> "Error";
        };
        Chips chips = new Chips(type);
        order.addItem(chips);
        System.out.println("Chips added: " + chips);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void addDrink(Order order) {
        System.out.println("""
 ╒══════════════════════════════════════╕
        🥤  QUENCH YOUR THIRST  🥤
      Time for something refreshing!
 ╘══════════════════════════════════════╛
""");
        // Drink sizes

         List<Integer> flavorList = Arrays.asList(1,2,3,4,5,0);
        System.out.println("Drink options:\n1) Soda\n2) Juice\n3) Water\n4) Chai\n5) Coffee\n0) Return to Order Menu");

        String flavor;
        int customerDrinkFlavor;

                while (true) {
                    customerDrinkFlavor = ConsoleHelper.promptForInt("Choose drink");

                    if (flavorList.contains(customerDrinkFlavor)) {
                        if (customerDrinkFlavor == 0) {
                            System.out.println("Returning to Order Menu...");
                            System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
                            return;
                        }
                        break;
                    } else {
                        System.out.println("Invalid drink flavor. Please choose from the options listed.");
                    }
                }

                flavor = switch (customerDrinkFlavor){
                  case 1 -> "Soda";
                  case 2 -> "Juice";
                  case 3 -> "Water";
                  case 4 -> "Chai";
                  case 5 -> "Coffee";
                    default -> "Error";
                };

        List<Integer> sizeList = Arrays.asList(1,2,3);
        System.out.println();
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        System.out.println("Drink sizes:\n1) Small\n2) Medium\n3) Large");
        String size;
        int customerDrinkSize;

        while (true) {
            customerDrinkSize = ConsoleHelper.promptForInt("Choose size");
            if (sizeList.contains(customerDrinkSize)) {
                break;
            } else {
                System.out.println("Invalid size. Please select a valid input.");
            }
        }
size = switch (customerDrinkSize){
  case 1 -> "Small";
  case 2 -> "Medium";
  case 3 -> "Large";
  default -> "Error";
};
        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
        System.out.println("Drink added: " + drink);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void addSignatureSandwich(Order order) {
        System.out.println("""
    ╒══════════════════════════════════════════╕
             🌟  SIGNATURE SANDWICH  🌟
       Handcrafted favorites, full of flavor!
    ╘══════════════════════════════════════════╛
""");

        List<Integer> signList = Arrays.asList(1, 2, 3, 4, 5,0);

        int customerSand;
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");

        while (true) {
            System.out.println("1) BLT (8 Inch Toasted White bread, Bacon, Cheddar, Lettuce, Tomatoes, and Mayo) for $10.50\n2) Philly (8 Inch Toasted White bread, Steak, American, Peppers, and Mayo) for $10.50\n3) Roast Beef (8 Inch White Toasted bread, Roast beef, Provolone, Lettuce, Onions, Tomatoes, and Mayo) for $10.50\n4) Chicken Wrap (8 Inch Toasted Wrap, Chicken, Cheddar, Lettuce, Tomatoes, peppers, Onions and Mayo) for $10.50\n5) Grilled Ham (8 Inch Toasted Rye bread, Ham, Swiss, Pickles, Tomatoes, and Mayo) for $10.50\n0) Return to Order Menu");
            customerSand = ConsoleHelper.promptForInt("Choose signature sandwich");
            if (signList.contains(customerSand)) {
                if (customerSand == 0) {
                    System.out.println("Returning to Order Menu...");
                    System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
                    return;
                }
                break;
            } else {
                System.out.println("Invalid choice. Please choose from the options listed.");
            }
        }
        SignSandwich sand = switch (customerSand) {
            case 1 -> new BLT();
            case 2 -> new Philly();
            case 3 -> new RoastBeef();
            case 4 -> new ChickenWrap();
            case 5 -> new GrilledHam();
            default -> null;
        };
        order.addItem(sand);
        if (sand != null){
        System.out.println("Signature sandwich added: " + sand.getSignName());
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        }
    }

    private boolean checkout(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your order is empty! Please add items before checking out.");
            return false;
        }

        System.out.println("""
 ╒═══════════════════════════════════════╕
            🛒  FINAL STOP  🛒
    Would you like to add anything else?
 ╘═══════════════════════════════════════╛
""");
        System.out.println(order.getReceiptContent());

        boolean confirm = ConsoleHelper.promptForYesNo("Confirm order?");

        if (!confirm) {
            System.out.println("Checkout cancelled. Returning to the order menu...");
            System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
            return false;
        } else {
            saveReceiptToFileAndFolder(order);
            System.out.println("Order confirmed! Thank you for your purchase.");
        }
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        return true;
    } // Maybe make a checkout class?

    private void saveReceiptToFileAndFolder(Order order) {
        try {
            FileWriter fw = new FileWriter(order.getReceiptFileName()); // Makes the receipt text file.
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.getReceiptContent()); // Displays the file's context in checkout.
            bw.close();

            System.out.println("【Receipt saved as: " + order.getReceiptFileName() + "】"); // Prints it into the checkout program.

        } catch (IOException e) {
            System.out.println("【Error saving receipt: " + e.getMessage()+ "】");
        }
    }

}