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
    private static String[] sides = {"Au Jus", "Sauce", "No Side"};

    private static float[] sizePrices = {5.50f, 7.00f, 8.50f};

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
        String size = sizes[command - 1];
        float price = sizePrices[command - 1];

        // Select bread
        command = selectOption("Select your bread", breadTypes);
        if (command == -1) return;
        String breadType = breadTypes[command - 1];

        // Select meat toppings
        command = selectOption("What meat toppings would you like to add?", meatToppings);
        if (command == -1) return;
        String meatType = meatToppings[command - 1];

        // Extra meat
        boolean extraMeat = false;
        command = selectOption("Would you like extra meat for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) extraMeat = true;

        // Select cheese toppings
        command = selectOption("What cheese toppings would you like to add?", cheeseToppings);
        if (command == -1) return;
        String cheeseType = cheeseToppings[command - 1];

        // Extra cheese
        boolean extraCheese = false;
        command = selectOption("Would you like extra cheese for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) extraCheese = true;

        // Regular toppings
        command = selectOption("We also have regular toppings which are included. Would you like to add anything?", regularToppings);
        if (command == -1) return;
        String regularTopping = regularToppings[command - 1];

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
        Sandwich sandwich = new Sandwich(size, new String[]{breadType}, new String[]{meatType}, new String[]{cheeseType},
                new String[]{regularTopping}, new String[]{sauce}, new String[]{side}, price);
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
        System.out.println("Added Drink");
    }

    private void addChips() {
        System.out.println("Added Chips");
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

