package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static  Order order;
    private static Scanner scanner = new Scanner(System.in);

    private static  String[] BREAD_TYPES = {"White", "Wheat", "Rye", "Wrap"};
    private static  String[] SIZES = {"4'", "8'", "12'"};
    private static  String[] MEAT_TOPPINGS = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private static  String[] CHEESE_TOPPINGS = {"American", "Provolone", "Cheddar", "Swiss"};
    private static  String[] REGULAR_TOPPINGS = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static  String[] SAUCES = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
    private static  String[] SIDES = {"Au Jus", "Sauce", "No Side"};

    private static float[] SIZE_PRICE = {5.50f, 7.00f, 8.50f};

    public void display() {
        init();

        int mainMenuCommand;

        do {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("2) Exit");

            System.out.println("Please choose an option: ");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {

                case 1:
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

    private void init() {
//        order = OrderFileManager.saveOrder();
        order = new Order("2024-05-24", "Dan", "Kelly");
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
            scanner.nextLine();

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

            }
        } while (command != 4 && command != 0);
    }


    private void addSandwich() {


            int command;

            // Select bread
            command = selectOption("Select your bread", BREAD_TYPES);
            if (command == -1) return;

            // Select size

        int sizeCommand = selectOption("What size would you like?", SIZES);
            if ( sizeCommand == -1) return;

            switch (sizeCommand){
                case 1:
                    order.addFourInchSize(SIZE_PRICE[0]);
                    break;
                case 2:
                    order.addEightInchSize(SIZE_PRICE[1]);
                    break;
                case 3:
                    order.addTwelveInchSandwich(SIZE_PRICE[2]);
                    break;
                default:
                    System.out.println("Invalid size selected");
                    break;
            }

            // Select meat toppings
            command = selectOption("What meat toppings would you like to add?", MEAT_TOPPINGS);
            if (command == -1) return;

            // Extra meat
            command = selectOption("Would you like extra meat for an additional cost?", new String[]{"Yes", "No"});
            if (command == -1) return;

            // Select cheese toppings
            command = selectOption("What cheese toppings would you like to add?", CHEESE_TOPPINGS);
            if (command == -1) return;

            // Extra cheese
            command = selectOption("Would you like extra cheese for an additional cost?", new String[]{"Yes", "No"});
            if (command == -1) return;

            // Regular toppings
            command = selectOption("We also have regular toppings which are included. Would you like to add anything?", REGULAR_TOPPINGS);
            if (command == -1) return;

            // Select sauce
            command = selectOption("What sauce would you like on your sandwich?", SAUCES);
            if (command == -1) return;

            // Add side
            command = selectOption("Would you like to add a side?", SIDES);
            if (command == -1) return;

            // Toasted bread
            command = selectOption("Would you like your bread toasted?", new String[]{"Yes", "No"});
            if (command == -1) return;

            System.out.println("Sandwich order complete.");


    }

    private int selectOption(String prompt, String[] options) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i]);
        }

        int command = scanner.nextInt();
        scanner.nextLine();

        if (command < 1 || command > options.length) {
            System.out.println("Invalid input. Please try again.");
            return -1;
        }

        System.out.println("You selected: " + options[command - 1]);
        return command;
    }

    private void addDrink(){
        System.out.println("Added Drink");
    }

    private void addChips(){
        System.out.println("Add chips");
    }

    public void checkout(){
        float total = order.calcTotal();

        System.out.println("Total price: $" + total);

    }

    private void cancelOrder(){
        System.out.println(" Order is cancelled");
    }


}
