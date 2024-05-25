package com.ps;

import java.util.ArrayList;

public class Order {

    private String date;
    private String customerName;
    private String serverName;
    private String orderId;

    private ArrayList<Products> products;

    public Order(String date, String customerName, String serverName, String orderId, ArrayList<Products> products) {
        this.date = date;
        this.customerName = customerName;
        this.serverName = serverName;
        this.orderId = orderId;
        this.products =  new ArrayList<>();
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Products> getProduts() {
        return products;
    }

    public void setProduts(ArrayList<Products> produts) {
        this.products = produts;
    }

   public void addProduct(Products products){
        this.products.add(products);
   }


    public void removeProducts(Products products){
        this.products.remove(products);
    }


//    calcTotal();

    public void calcTotal(Products products){
//        ArrayList<Products> totalArr = new ArrayList<>();
//
//        for (Products product: this.produts){
//            if (product.calcPrice()){
//                ;
//            }
//        }
    }

//    checkOut();







}
