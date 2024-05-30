package com.ps;

public class AddOns extends Products {
    private float price;
    private String type;

    public AddOns(float price, String type) {
        super(price, type);
        this.price = price;
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void calcPrice() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AddOns{" +
                "price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
