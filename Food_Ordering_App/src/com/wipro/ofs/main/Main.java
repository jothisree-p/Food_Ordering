package com.wipro.ofs.main; 
 
import java.util.ArrayList; 
import com.wipro.ofs.entity.*; 
import com.wipro.ofs.service.FoodOrderService; 
import com.wipro.ofs.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<User> users = new ArrayList<>(); 
        users.add(new User("U001", "Karan", "9876543210")); 
        users.add(new User("U002", "Neha", "9123456780")); 
 
        ArrayList<MenuItem> menu = new ArrayList<>(); 
        menu.add(new MenuItem("M101", "Veg Burger", 120.0, 15)); 
        menu.add(new MenuItem("M202", "Chicken Wings", 250.0, 10)); 
 
        ArrayList<Order> orders = new ArrayList<>(); 
 
        FoodOrderService service = new FoodOrderService(users, menu, orders); 
 
        try { 
            ArrayList<CartItem> cart = new ArrayList<>(); 
            cart.add(new CartItem("M101", 2)); 
            cart.add(new CartItem("M202", 1)); 
            Order o1 = service.placeOrder("U001", cart); 
            System.out.println("Order Placed Successfully: " + o1.getOrderId()); 
            service.printUserOrders("U001"); 
            System.out.println("\nCancelling Order..."); 
            service.cancelOrder(o1.getOrderId()); 
            System.out.println("Order Cancelled!"); 
        } catch (InvalidUserException | ItemNotFoundException | 
                 OutOfStockException | OrderNotFoundException | 
                 OrderOperationException ex) { 
            System.out.println(ex); 
        } 
        catch (Exception ex) { 
            System.out.println("Unexpected Error: " + ex); 
        } 
    } 
} 
