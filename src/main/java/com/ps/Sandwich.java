package com.ps;

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
        return "Sandwich{" +
                "size=" + size +
                ", breadType=" + Arrays.toString(breadType) +
                ", meatType=" + Arrays.toString(meatType) +
                ", cheeseType=" + Arrays.toString(cheeseType) +
                ", regularToppings=" + Arrays.toString(regularToppings) +
                ", sauces=" + Arrays.toString(sauces) +
                ", sides=" + Arrays.toString(sides) +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                ", toasted=" + toasted +
                '}';
    }
}
