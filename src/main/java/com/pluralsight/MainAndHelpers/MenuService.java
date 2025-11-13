package com.pluralsight.MainAndHelpers;

import com.pluralsight.Orders.*;
import com.pluralsight.SignatureSandwiches.*;
import com.pluralsight.ToppingsPackage.*;
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
            String orderMenu = "What would you like to order?\n 1) Add Sandwich\n 2) Add Drink\n 3) Add Chips\n 4) Add Signature Sandwich\n 5) Edit Sandwich\n 6) Checkout\n 0) Cancel Order\n『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』\n";
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
                    editSandwich(currentOrder);
                    System.out.println();
                    break;

                case 6:
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
    ╔══════════════════════════════════════════════╗
             🌯  DESI SANDWICH BUILDER  🌯
      Let's make a sandwich worthy of your hunger!
    ╚══════════════════════════════════════════════╝
    """);

        String bread = ConsoleHelper.promptForHelperMenu("Choose your bread:", List.of("White", "Wheat", "Rye", "Wrap"), true);
        if (bread == null) return; // User chose to cancel.

        String sandSize = ConsoleHelper.promptForHelperMenu("Choose sandwich size:", List.of("4\"", "8\"", "12\""), true);
        if (sandSize == null) return;
        int length = Integer.parseInt(sandSize.replace("\"", "")); // Replaces the inch symbol with a space so that it can act as an integer.

        boolean toasted = ConsoleHelper.promptForYesNo("Would you like it toasted?");
        Sandwich sandwich = new Sandwich(bread, length, toasted);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
        // Add meats
        while (ConsoleHelper.promptForYesNo("Add meat?")) {
            String meatType = ConsoleHelper.promptForHelperMenu("Choose meat:" , List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"), true);
            if (meatType == null)
                break;
            boolean extra = ConsoleHelper.promptForYesNo("Extra meat?");
            sandwich.addTopping(new Meat(meatType, extra));
        }
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");

        // Add cheese
        while (ConsoleHelper.promptForYesNo("Add cheese?")) {
            String cheeseType = ConsoleHelper.promptForHelperMenu("Choose cheese:", List.of("American", "Provolone", "Cheddar", "Swiss"), true);
            if (cheeseType == null)
                break;
            boolean extra = ConsoleHelper.promptForYesNo("Extra cheese?");
            sandwich.addTopping(new Cheese(cheeseType, extra));
        }
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");

        // Add regular toppings
        while (ConsoleHelper.promptForYesNo("Add regular toppings?")) {
            String toppingType = ConsoleHelper.promptForHelperMenu("Choose topping:", List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"), true);
            if (toppingType == null)
                break;
            sandwich.addTopping(new Toppings(toppingType) {});
        }
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");

        // Add sauces
        while (ConsoleHelper.promptForYesNo("Add sauce?")) {
            String sauceType = ConsoleHelper.promptForHelperMenu("Choose sauce:", List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"), true);
            if (sauceType == null)
                break;
            sandwich.addTopping(new Sauce(sauceType));
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

        String chipType = ConsoleHelper.promptForHelperMenu("Choose your chips:", List.of("BBQ", "Plain", "Sour Cream", "Salt & Vinegar", "Cheddar"), true);
        if (chipType == null)
            return;

        Chips chips = new Chips(chipType);
        order.addItem(chips);
        System.out.println("Chips added: " + chips);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void addDrink(Order order) {
        System.out.println("""
    ╒═════════════════════════════════════╕
          🥤  QUENCH YOUR THIRST  🥤
         Time for something refreshing
    ╘═════════════════════════════════════╛
    """);

        String size = ConsoleHelper.promptForHelperMenu("Choose drink size:", List.of("Small", "Medium", "Large"), true);
        if (size == null)
            return;

        String flavor = ConsoleHelper.promptForHelperMenu("Choose beverage type:", List.of("Soda", "Water", "Juice", "Iced Tea", "Dirty Chai"), true);
        if (flavor == null)
            return;

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
        System.out.println("Drink added: " + drink);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void addSignatureSandwich(Order order) {
        System.out.println("""
                ╔══════════════════════════════════════╗
                     ✨  SIGNATURE SANDWICHES  ✨
                    Crafted favorites ready to serve!
                ╚══════════════════════════════════════╝
                """);

        List<String> signList = List.of("BLT", "Philly", "Chicken Wrap", "Grilled Ham", "Roast Beef");
        String selected = ConsoleHelper.promptForHelperMenu("Choose your signature sandwich:", signList, true);
        if (selected == null)
            return;

        SignSandwich sandwich = switch (selected) {
            case "BLT" -> new BLT();
            case "Philly" -> new Philly();
            case "Chicken Wrap" -> new ChickenWrap();
            case "Grilled Ham" -> new GrilledHam();
            case "Roast Beef" -> new RoastBeef();
            default -> null;
        };
        order.addItem(sandwich);
        System.out.println("Signature sandwich added: " + sandwich);
        System.out.println("『━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━』");
    }

    private void editSandwich(Order order) {
        System.out.println("""
           ╒════════════════════════╕
             🎨  EDIT SANDWICH!  🎨
           ╘════════════════════════╛
""");
        // Go through the order to get sandwiches only:
        List<Sandwich> sandwiches = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            if (item instanceof Sandwich) {
                sandwiches.add((Sandwich) item);
            }
        }

        // If there aren't any sandwiches, you get sent back to the order menu:
        if (sandwiches.isEmpty()) {
            System.out.println("No sandwiches to edit in this order.");
            return;
        }

        // Prompt for user to choose which sandwich they'd like to edit:
        List<String> sandwichList = new ArrayList<>();
        for (Sandwich s : sandwiches) {
            sandwichList.add(s.toString()); // Makes readable line. example:( 8" | Toasted | White bread| etc. )
        }

        String chosenSandwich = ConsoleHelper.promptForHelperMenu("Select a sandwich to edit:", sandwichList, true);

        if (chosenSandwich == null) // Cancel/Return option
            return;

        // Find the sandwich that they selected from above:
        Sandwich selected = null; // Starts as null so that String choice "selected" is initialized.
        for (Sandwich s : sandwiches) {
            if (s.toString().equals(chosenSandwich)) {
                selected = s;
                break; // If all goes well.
            }
        }
        if (selected == null)
            return; // Safety net for selected remaining as null.

        // Editing menu:
        boolean editSandwich = true;
        while (editSandwich) {
            String choice = ConsoleHelper.promptForHelperMenu("Editing: " + selected + "\nWhat would you like to do?", List.of("Change bread", "Change size", "Toggle toasted", "Add topping", "Remove topping", "Return to previous menu"), false);

            switch (choice) {
                case "Change bread" -> {
                    String changedBread = ConsoleHelper.promptForHelperMenu("Choose new bread:", List.of("White", "Wheat", "Rye", "Wrap"), true);
                    if (changedBread != null) {
                        selected.setBread(changedBread);
                        System.out.println("Bread changed to " + changedBread + ".");
                    }
                }

                case "Change size" -> {
                    String changedSize = ConsoleHelper.promptForHelperMenu("Choose sandwich size:", List.of("4\"", "8\"", "12\""), true);
                    if (changedSize != null) {
                        int newLength = Integer.parseInt(changedSize.replace("\"", ""));
                        selected.setLength(newLength);
                        System.out.println("Size changed to " + newLength + "\".");
                    }
                }

                case "Toggle toasted" -> {
                    selected.setToasted(!selected.isToasted());
                    System.out.println("Changed toasted option!");
                }

                case "Add topping" -> {
                    String addedTopping = ConsoleHelper.promptForHelperMenu("Choose topping to add:", List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"), true);
                    if (addedTopping != null) {
                        selected.addTopping(new Toppings(addedTopping) {});
                        System.out.println(addedTopping + " added!");
                    }
                }

                case "Remove topping" -> {
                    if (selected.getToppings().isEmpty()) {
                        System.out.println("No toppings to remove.");
                        break;
                    }

                    List<String> toppingNames = new ArrayList<>();
                    for (Toppings t : selected.getToppings()) {
                        toppingNames.add(t.getName());
                    }

                    String toRemove = ConsoleHelper.promptForHelperMenu(
                            "Select topping to remove:", toppingNames, true);
                    if (toRemove != null) {
                        for (int i = 0; i < selected.getToppings().size(); i++) {
                            if (selected.getToppings().get(i).getName().equalsIgnoreCase(toRemove)) {
                                selected.getToppings().remove(i);
                                System.out.println(toRemove + " removed!");
                                break;
                            }
                        }
                    }
                }

                case "Return to editing menu" -> editSandwich = false; // Basically closes out the editing.

                case null -> {} // Didn't want any error signs so just added this.
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
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
    }

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