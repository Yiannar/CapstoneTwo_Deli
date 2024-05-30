package com.ps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {

    private static Order order;
    private static Scanner scanner = new Scanner(System.in);

    private static String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private static String[] sizes = {"4\"", "8\"", "12\""};
    private static String[] meatToppings = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private static String[] cheeseToppings = {"American", "Provolone", "Cheddar", "Swiss"};
    private static String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
    private static String[] sides = {"Au Jus", "Sauce", "No Side"};;


private static float[] sizePrices = {5.50f, 7.00f, 8.50f};
private static float[] meatPrices = {1.00f, 2.00f, 3.00f };
private static float[] extraMeatPrices = {0.50f, 1.00f, 1.50f};
private static float[] cheesePrices = {0.75f, 1.50f, 2.25f};
private static float[] extraCheesePrices = {0.30f, 0.60f, 0.90f};
private static String[] drinkSizes = {"Small", "Medium", "Large"};
private static float[] drinkPrices = {2.00f, 2.50f, 3.00f};
private static float chipsPrice = 1.50f;


    public void display() {
        int mainMenuCommand;

        do {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("2) Exit");

            System.out.println("Please choose an option: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                    String date = LocalDateTime.now().format(dateTimeFormatter);

                    scanner.nextLine();  // Consume newline
                    System.out.println("What is the customer's name?");
                    String customerName = scanner.nextLine();

                    System.out.println("Server: ");
                    String serverName = scanner.nextLine();

                    init(date, customerName, serverName);
                    handleNewOrder();
                    break;

                case 2:
                    System.out.println("Exiting.....");
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

        } while (mainMenuCommand != 2);
    }

    private void init(String date, String customerName, String serverName) {
        order = new Order(date, customerName, serverName);
    }

    private void handleNewOrder() {
        int command;

        do {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            command = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (command) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (command != 4 && command != 0);
    }
    private void addSandwich() {
        int command;

        // Select size
        command = selectOption("What size would you like?", sizes);
        if (command == -1) return;
        int sizeIndex = command; // Store the selected size index
        float sizePrice = sizePrices[sizeIndex - 1]; // Get the base price based on the selected size

        // Select bread
        command = selectOption("Select your bread", breadTypes);
        if (command == -1) return;
        String breadType = breadTypes[command - 1];

        // Select meat toppings
        command = selectOption("What meat toppings would you like to add?", meatToppings);
        if (command == -1) return;
        String meatType = meatToppings[command - 1];

        // Calculate meat price based on the selected size
        float meatPrice = meatPrices[sizeIndex - 1]; // Get the base price for the selected size

        // Debug prints
        System.out.println("Size price: " + sizePrice);
        System.out.println("Meat price: " + meatPrice);

        // Calculate total sandwich price
        float totalPrice = sizePrice;

        // Debug print
        System.out.println("Total price before adding toppings: " + totalPrice);

        // Update the existing totalPrice variable with the additional meat price
        totalPrice += meatPrice;

        // Display total price
        System.out.println("Total price: $" + totalPrice);

        // Extra meat
        boolean extraMeat = false;
        command = selectOption("Would you like extra meat for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) {
            extraMeat = true;
            meatPrice += extraMeatPrices[sizeIndex - 1]; // Add extra meat price if selected
        }

        // Select cheese toppings
        command = selectOption("What cheese toppings would you like to add?", cheeseToppings);
        if (command == -1) return;
        String cheeseType = cheeseToppings[command - 1];
        float cheesePrice = cheesePrices[sizeIndex - 1]; // Get the price based on the selected cheese type

        // Extra cheese
        boolean extraCheese = false;
        command = selectOption("Would you like extra cheese for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) {
            extraCheese = true;
            // Add extra cheese price if selected
            cheesePrice += extraCheesePrices[sizeIndex - 1]; // Adjust the total price
        }

        // Update the total price with the cheese price
        totalPrice += cheesePrice;

        // Select sauce
        command = selectOption("What sauce would you like on your sandwich?", sauces);
        if (command == -1) return;
        String sauce = sauces[command - 1];

        // Add side
        command = selectOption("Would you like to add a side?", sides);
        if (command == -1) return;
        String side = sides[command - 1];

        // Toasted bread
        boolean toasted = false;
        command = selectOption("Would you like your bread toasted?", new String[]{"Yes", "No"});
        if (command == 1) toasted = true;

        // Create sandwich and add to order
        Sandwich sandwich = new Sandwich(sizes[sizeIndex - 1], new String[]{breadType}, new String[] {meatType}, new String[] {cheeseType},
                regularToppings, sauces, sides, totalPrice);
        sandwich.setToasted(toasted);
        sandwich.setExtraMeat(extraMeat);
        sandwich.setExtraCheese(extraCheese);
        order.addProduct(sandwich);

        System.out.println("Sandwich order complete.");
    }




    private int selectOption(String prompt, String[] options) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i]);
        }

        int command = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (command < 1 || command > options.length) {
            System.out.println("Invalid input. Please try again.");
            return -1;
        }

        System.out.println("You selected: " + options[command - 1]);
        return command;
    }

    private void addDrink() {
    // Select drink size
    int command = selectOption("What size drink would you like?", drinkSizes);
    if (command == -1) return;
    String size = drinkSizes[command - 1];
    float price = drinkPrices[command - 1]; // Get the price based on the selected size

    // Create drink add-on
    AddOns drink = new AddOns(price,"Drink");
    order.addProduct(drink);

    // Add drink price to the total
    order.addToTotal(price);

    System.out.println("Drink added.");
}


private void addChips() {
    // Create chips add-on
    AddOns chips = new AddOns(chipsPrice, "Chips");
    order.addProduct(chips);

    // Add chips price to the total
    order.addToTotal(chipsPrice);

    System.out.println("Chips added.");
}


    private void checkout() {
        float total = order.calcTotal();
        System.out.println("Total price: $" + total);
        OrderFileManager.saveOrder(order);
    }


    private void cancelOrder() {

        System.out.println("Order is cancelled");

    }
}
