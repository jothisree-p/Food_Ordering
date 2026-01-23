package com.wipro.ofs.entity;

public class MenuItem {
    private String itemId;
    private String itemName;
    private double price;
    private int stock;

    public MenuItem(String itemId, String itemName, double price, int stock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
    }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
}
