package com.wipro.ofs.service;

import java.util.ArrayList;
import java.util.UUID;
import com.wipro.ofs.entity.*;
import com.wipro.ofs.util.*;

public class FoodOrderService {

    private ArrayList<User> users;
    private ArrayList<MenuItem> menu;
    private ArrayList<Order> orders;

    public FoodOrderService(ArrayList<User> users, ArrayList<MenuItem> menu, ArrayList<Order> orders) {
        this.users = users;
        this.menu = menu;
        this.orders = orders;
    }

    public boolean validateUser(String userId) throws InvalidUserException {
        for (User u : users) {
            if (u.getUserId().equals(userId)) return true;
        }
        throw new InvalidUserException();
    }

    public MenuItem findMenuItem(String itemId) throws ItemNotFoundException {
        for (MenuItem m : menu) {
            if (m.getItemId().equals(itemId)) return m;
        }
        throw new ItemNotFoundException();
    }

    public void checkStock(String itemId, int qty) throws OutOfStockException, ItemNotFoundException {
        MenuItem item = findMenuItem(itemId);
        if (qty > item.getStock()) throw new OutOfStockException();
    }

    public Order placeOrder(String userId, ArrayList<CartItem> cart)
            throws InvalidUserException, ItemNotFoundException,
                   OutOfStockException, OrderOperationException {

        if (cart == null || cart.isEmpty()) throw new OrderOperationException();
        validateUser(userId);

        for (CartItem c : cart) {
            if (c.getQuantity() <= 0) throw new OrderOperationException();
            checkStock(c.getItemId(), c.getQuantity());
        }

        for (CartItem c : cart) {
            MenuItem item = findMenuItem(c.getItemId());
            item.setStock(item.getStock() - c.getQuantity());
        }

        double total = calculateTotal(cart);
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        Order order = new Order(orderId, userId, cart, total);
        orders.add(order);
        return order;
    }

    private double calculateTotal(ArrayList<CartItem> cart) throws ItemNotFoundException {
        double sum = 0;
        for (CartItem c : cart) {
            MenuItem item = findMenuItem(c.getItemId());
            sum += item.getPrice() * c.getQuantity();
        }
        return sum;
    }

    public void cancelOrder(String orderId) throws OrderNotFoundException, ItemNotFoundException {
        Order found = null;
        for (Order o : orders) {
            if (o.getOrderId().equals(orderId)) {
                found = o;
                break;
            }
        }
        if (found == null) throw new OrderNotFoundException();

        for (CartItem c : found.getItems()) {
            MenuItem item = findMenuItem(c.getItemId());
            item.setStock(item.getStock() + c.getQuantity());
        }
        orders.remove(found);
    }

    public void printUserOrders(String userId) {
        for (Order o : orders) {
            if (o.getUserId().equals(userId)) {
                System.out.println("Order ID: " + o.getOrderId() + " | Total: ₹" + o.getTotalAmount());
            }
        }
    }
}
