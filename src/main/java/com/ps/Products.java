package com.ps;

abstract public class Products {
    private float price;

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
                '}';
    }
}
