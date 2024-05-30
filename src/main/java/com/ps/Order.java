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

    public void addProduct(Products products) {
        this.products.add(products);
    }


    public void removeProducts(Products products) {
        this.products.remove(products);
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


}