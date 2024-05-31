package com.ps;

import java.util.ArrayList;

public class Order {

    private String date;
    private String customerName;
    private String serverName;
    private float total;

    private ArrayList<Products> products;

    private static float fourInchPrice = 5.50f;
    private static float eightInchPrice = 7.00f;
    private static float tweleveInchPrice = 8.50f;

    public Order(String date, String customerName, String serverName) {
        this.date = date;
        this.customerName = customerName;
        this.serverName = serverName;

        this.products = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public void addProduct(Products product) {
        products.add(product);
        total += product.getPrice();

    }


    public void removeProduct(Products product) {
        // Check if the product exists in the order
        products.remove(product);
        total -= product.getPrice();
    }

    public void addFourInchSize(float sizePrice) {
        Products sandwich = new Sandwich(fourInchPrice);
        this.products.add(sandwich);
    }

    public void addEightInchSize(float sizePrice) {
        Products sandwich = new Sandwich(eightInchPrice);
        this.products.add(sandwich);
    }

    public void addTweleveInchPrice(float sizePrice) {
        Products sandwich = new Sandwich(tweleveInchPrice);
        this.products.add(sandwich);
    }

    public void addToTotal(float price) {
        total += price;
    }

    public float calcTotal() {
        float total = 0;
        for (Products product : this.products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Date: ").append(date).append("\n")
                .append("Customer: ").append(customerName).append("\n")
                .append("Server: ").append(serverName).append("\n")
                .append("-------------------------------\n")
                .append("Products:\n");

        for (Products product : products) {
            receipt.append(product.toString()).append("\n");
        }

        float subtotal = calcTotal();
        float tax = subtotal * 0.08f;
        float totalPrice = subtotal + tax;

        receipt.append("-------------------------------\n")
                .append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n")
                .append("Tax: $").append(String.format("%.2f", tax)).append("\n")
                .append("Total: $").append(String.format("%.2f", totalPrice)).append("\n");

        return receipt.toString();
    }



}