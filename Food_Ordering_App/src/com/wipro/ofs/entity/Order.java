package com.wipro.ofs.entity;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String userId;
    private ArrayList<CartItem> items;
    private double totalAmount;

    public Order(String orderId, String userId, ArrayList<CartItem> items, double totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public ArrayList<CartItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
}
