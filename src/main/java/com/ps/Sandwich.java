package com.ps;

import java.util.ArrayList;
import java.util.Arrays;

public class Sandwich extends Products {

    private String size;
    private String[] breadType;
    private String[] meatType;
    private String[] cheeseType;
    private String[] regularToppings;
    private String[] sauces;
    private String[] sides;
    private boolean extraMeat;
    private boolean extraCheese;
    private boolean toasted;

    private ArrayList<Float> price = new ArrayList<>();


    // Constructor with all parameters
    public Sandwich(String size, String[] breadType, String[] meatType, String[] cheeseType, String[] regularToppings, String[] sauces, String[] sides, float price) {
        super(price, "Sandwich");
        this.size = size;
        this.breadType = breadType;
        this.meatType = meatType;
        this.cheeseType = cheeseType;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.price = new ArrayList<>();
    }

    // Default constructor
    public Sandwich() {
        super(0, "Sandwich");
        this.size = "0";
        this.breadType = new String[]{"white", "wheat", "rye", "wrap"};
        this.meatType = new String[]{"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
        this.cheeseType = new String[]{"american", "provolone", "cheddar", "swiss"};
        this.regularToppings = new String[]{"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
        this.sauces = new String[]{"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
        this.sides = new String[]{"au jus", "sauce"};
    }

    public Sandwich(float fourInchPrice) {
        super(fourInchPrice, "sandwich");
    }

    public Sandwich(String[] size, String[] breadType, String[] meatType, String[] cheeseType, String[] regularToppings, String[] sauces, String[] sides) {
        super(0, "Sandwich");
    }

//    public Sandwich(String size, String[] breadTypes, String meatType, String cheeseType, String[] regularToppings, String[] sauces, String[] sides, float totalPrice) {
//        super(0f,"name");
//    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getBreadType() {
        return breadType;
    }

    public void setBreadType(String[] breadType) {
        this.breadType = breadType;
    }

    public String[] getMeatType() {
        return meatType;
    }

    public void setMeatType(String[] meatType) {
        this.meatType = meatType;
    }

    public String[] getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(String[] cheeseType) {
        this.cheeseType = cheeseType;
    }

    public String[] getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(String[] regularToppings) {
        this.regularToppings = regularToppings;
    }

    public String[] getSauces() {
        return sauces;
    }

    public void setSauces(String[] sauces) {
        this.sauces = sauces;
    }

    public String[] getSides() {
        return sides;
    }

    public void setSides(String[] sides) {
        this.sides = sides;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public void calcPrice() {
        // Add logic here to calculate the price of the sandwich
    }
    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("SANDWICH: Size: ").append(size).append("\n");
        format.append(" Bread type: ").append(String.join(", ", breadType)).append("\n");
        format.append(" Meat type: ").append(String.join(", ", meatType)).append("\n");
        format.append(" Cheese type: ").append(String.join(", ", cheeseType)).append("\n");
        format.append(" Regular toppings: ").append(String.join(", ", regularToppings)).append("\n");
        format.append(" Sauces: ").append(String.join(", ", sauces)).append("\n");
        format.append(" Sides: ").append(String.join(", ", sides)).append("\n");
        format.append(" Extra meat: ").append(extraMeat).append("\n");
        format.append(" Extra cheese: ").append(extraCheese).append("\n");
        format.append(" Toasted: ").append(toasted).append("\n");
        format.append(" Price: $").append(price).append("\n");
        return format.toString();
    }



}
