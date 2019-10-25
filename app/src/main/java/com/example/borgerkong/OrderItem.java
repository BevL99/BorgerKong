package com.example.borgerkong;

import java.util.ArrayList;

public class OrderItem {


    private String orderItemID;
    private String orderItemName;
    private double orderItemPrice;
    private int orderItemImage;
    private int orderQuantity;

    public OrderItem(){

    }

    public OrderItem(String orderItemID, String orderItemName, double orderItemPrice, int orderItemImage, int orderQuantity){
        this.orderItemID = orderItemID;
        this.orderItemName = orderItemName;
        this.orderItemPrice = orderItemPrice;
        this.orderItemImage = orderItemImage;
        this.orderQuantity = orderQuantity;
        }

    public String getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(String orderItemID) {
        this.orderItemID = orderItemID;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public int getOrderItemImage() {
        return orderItemImage;
    }

    public void setOrderItemImage(int orderItemImage) {
        this.orderItemImage = orderItemImage;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
