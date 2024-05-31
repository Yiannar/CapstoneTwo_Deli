package com.ps;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
    private static float[] meatPrices = {1.00f, 2.00f, 3.00f};
    private static float[] extraMeatPrices = {0.50f, 1.00f, 1.50f};
    private static float[] cheesePrices = {0.75f, 1.50f, 2.25f};
    private static float[] extraCheesePrices = {0.30f, 0.60f, 0.90f};
    private static String[] drinkSizes = {"Small", "Medium", "Large"};
    private static float[] drinkPrices = {2.00f, 2.50f, 3.00f};
    private static float chipsPrice = 1.50f;

    private static float taxRate = 0.08f;

    public void display() {
        int mainMenuCommand;

        do {
            System.out.println("*******************Welcome to DELI-cious*******************");
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
            System.out.println("2) Order Signature Sandwiches");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");

            command = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (command) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    orderSignatureSandwich();
                    break;
                case 3:
                    addDrink();
                    break;
                case 4:
                    addChips();
                    break;
                case 5:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (command != 5 && command != 0);
    }

    private void addSandwich() {
        int command;

        // Select size
        command = selectOption("What size would you like?", sizes);
        if (command == -1) return;
        int sizeIndex = command - 1; // Store the selected size index
        float sizePrice = sizePrices[sizeIndex]; // Get the base price based on the selected size

        // Select bread
        command = selectOption("Select your bread", breadTypes);
        if (command == -1) return;
        String breadType = breadTypes[command - 1];

        // Select meat toppings
        command = selectOption("What meat toppings would you like to add?", meatToppings);
        if (command == -1) return;
        String meatType = meatToppings[command - 1];

        // Calculate meat price based on the selected size
        float meatPrice = meatPrices[sizeIndex]; // Get the base price for the selected size

        // Extra meat
        boolean extraMeat = false;
        command = selectOption("Would you like extra meat for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) {
            extraMeat = true;
            meatPrice += extraMeatPrices[sizeIndex]; // Add extra meat price if selected
        }

        // Select cheese toppings
        command = selectOption("What cheese toppings would you like to add?", cheeseToppings);
        if (command == -1) return;
        String cheeseType = cheeseToppings[command - 1];
        float cheesePrice = cheesePrices[sizeIndex]; // Get the price based on the selected cheese type

        // Extra cheese
        boolean extraCheese = false;
        command = selectOption("Would you like extra cheese for an additional cost?", new String[]{"Yes", "No"});
        if (command == 1) {
            extraCheese = true;
            // Add extra cheese price if selected
            cheesePrice += extraCheesePrices[sizeIndex];
        }

        // Select regular topping
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

        // Calculate total sandwich price
        float totalPrice = sizePrice + meatPrice + cheesePrice;

        // Create arrays for sandwich components
        String[] breadArray = {breadType}; // Assuming breadType is a String
        String[] meatArray = {meatType}; // Assuming meatType is a String
        String[] cheeseArray = {cheeseType}; // Assuming cheeseType is a String
        String[] regularToppingArray = {regularTopping}; // Assuming regularTopping is a String
        String[] sauceArray = {sauce}; // Assuming sauce is a String
        String[] sideArray = {side}; // Assuming side is a String

        // Create the sandwich object
        Sandwich sandwich = new Sandwich(sizes[sizeIndex],
                breadArray,
                meatArray,
                cheeseArray,
                regularToppingArray,
                sauceArray,
                sideArray,
                totalPrice);
        sandwich.setToasted(toasted);
        sandwich.setExtraMeat(extraMeat);
        sandwich.setExtraCheese(extraCheese);

        // Add the sandwich to the order
        order.addProduct(sandwich);

        // Debug prints
        System.out.println("Size price: " + sizePrice);
        System.out.println("Meat price: " + meatPrice);
        System.out.println("Cheese price: " + cheesePrice);
        System.out.println("Total price before adding toppings: " + totalPrice);

        // Display total price
        System.out.println("Total price: $" + totalPrice);
    }




    private void orderSignatureSandwich() {
        SignatureSandwich[] signatureSandwiches = {
                new BLTSandwich(),
                new PhillyCheeseSteakSandwich()
        };

        String[] signatureNames = {"BLT", "Philly Cheese Steak"};
        int command = selectOption("Which signature sandwich would you like to order?", signatureNames);
        if (command == -1) return;

        SignatureSandwich selectedSandwich = signatureSandwiches[command - 1];
        printSandwichDetails(selectedSandwich);

        // If the user wants to customize, you could provide additional options to add/remove toppings here

        // Convert to a Sandwich object to add to the order
        Sandwich sandwich = new Sandwich(
                selectedSandwich.getSize(),
                selectedSandwich.getBread(),
                selectedSandwich.getMeat(),
                selectedSandwich.getCheese(),
                selectedSandwich.getToppings(),
                selectedSandwich.getSauces(),
                new String[]{}, // Sides can be added separately
                calculateTotalPrice(selectedSandwich)
        );
        sandwich.setToasted(selectedSandwich.isToasted());
        order.addProduct(sandwich);

        System.out.println("Signature sandwich order complete.");
    }

    private float calculateTotalPrice(SignatureSandwich sandwich) {
        int sizeIndex = Arrays.asList(sizes).indexOf(sandwich.getSize());
        float totalPrice = sizePrices[sizeIndex];

        for (String meat : sandwich.getMeat()) {
            totalPrice += meatPrices[sizeIndex];
        }

        for (String cheese : sandwich.getCheese()) {
            totalPrice += cheesePrices[sizeIndex];
        }


        return totalPrice;
    }

    private static void printSandwichDetails(SignatureSandwich sandwich) {
        System.out.println("Size: " + sandwich.getSize());
        System.out.println("Bread: " + Arrays.toString(sandwich.getBread()));
        System.out.println("Meat: " + Arrays.toString(sandwich.getMeat()));
        System.out.println("Cheese: " + Arrays.toString(sandwich.getCheese()));
        System.out.println("Toppings: " + Arrays.toString(sandwich.getToppings()));
        System.out.println("Sauces: " + Arrays.toString(sandwich.getSauces()));
        System.out.println("Toasted: " + sandwich.isToasted());
        System.out.println();
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
        AddOns drink = new AddOns(price, "Drink");
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
        // Display the order details and price
        float subtotal = order.calcTotal();
        float tax = subtotal * taxRate;
        float total = subtotal + tax;

        System.out.println("Order Details:");
        System.out.println(order.toString());
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax); // Display tax separately
        System.out.println("Total price (including tax): $" + total);

        // Prompt for tip (if desired)
        System.out.println("Enter tip amount (or percentage, e.g., '5' for $5 or '10%' for 10%):");
        String tipInput = scanner.nextLine();
        float tip = tip(tipInput, subtotal);
        total += tip;
        System.out.println("Total price (including tax and tip): $" + total);

        int command;
        do {
            System.out.println("1) Confirm");
            System.out.println("2) Cancel");
            System.out.println("Please choose an option:");

            command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    confirmOrder();
                    return;
                case 2:
                    cancelOrder();
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (true);
    }

    private float tip(String tipInput, float subtotal) {
        float tip = 0;
        if (tipInput.endsWith("%")) {
            // Tip is a percentage
            float percentage = Float.parseFloat(tipInput.replace("%", ""));
            tip = subtotal * (percentage / 100);
        } else {
            // Tip is a fixed amount
            tip = Float.parseFloat(tipInput);
        }
        return tip;

    }

    private void confirmOrder() {
        // Create the receipt file (you can implement this)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        String fileName = date + "Receipts/" + date + ".csv";

        OrderFileManager.saveOrder(order);
        System.out.println("Order confirmed. Receipt created.");
        // Reset the order for a new order
        order = null;
    }



    private void cancelOrder() {
        // Check if the order is not null
        if (order != null) {
            // Iterate over all products in the order and remove each one
            ArrayList<Products> products = new ArrayList<>(order.getProducts()); // Create a copy to avoid ConcurrentModificationException
            for (Products product : products) {
                order.removeProduct(product);
            }
            System.out.println("Order canceled. All products removed.");
        } else {
            System.out.println("No order to cancel.");
        }
    }


}
