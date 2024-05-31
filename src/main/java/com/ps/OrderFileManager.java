package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class OrderFileManager {

    public static void saveOrder(Order order) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String date = LocalDateTime.now().format(dateTimeFormatter);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Receipts/" + date + ".csv"))) {

            bufferedWriter.write(String.format("Date: %s\n Customer: %s\n Server: %s\n", order.getDate(), order.getCustomerName(), order.getServerName()));

            for (Products product : order.getProducts()) {
                if (product instanceof Sandwich sandwich) {
                    String size = sandwich.getSize();
                    String breadType = Arrays.toString(sandwich.getBreadType());
                    String meatType = Arrays.toString(sandwich.getMeatType());
                    String cheeseType = Arrays.toString(sandwich.getCheeseType());
                    String regToppings = Arrays.toString(sandwich.getRegularToppings());
                    String sauces = Arrays.toString(sandwich.getSauces());
                    String sides = Arrays.toString(sandwich.getSides());
                    Boolean extraMeat = sandwich.isExtraMeat();
                    Boolean extraCheese = sandwich.isExtraCheese();
                    Boolean isToasted = sandwich.isToasted();
                    Float price = sandwich.getPrice();

                    String sandwichOrder = String.format("*******************SANDWICH*******************\n Size: %s\n Bread: %s\n Meat: %s\n Cheese: %s\n Toppings: %s\n Sauce: %s\n Sides: %s\n Extra Meat: %b\n Extra Cheese: %b\n Toasted: %b\n *******************Price: %.2f*******************\n",
                            size, breadType, meatType, cheeseType, regToppings, sauces, sides, extraMeat, extraCheese, isToasted, price);

                    bufferedWriter.write(sandwichOrder);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
