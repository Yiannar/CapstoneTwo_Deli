package com.ps;

abstract public class Products {

    private float price;
    private String name;



    public Products(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract void calcPrice();

    @Override
    public String toString() {
        return "Products{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}