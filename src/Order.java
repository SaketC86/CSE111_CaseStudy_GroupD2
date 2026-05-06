package OnlineFoodSystem;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;

public class Order {
	private static int nextOrderID = loadLastOrderID();
    private int orderID;
    private String orderStatus;
    private String orderedItems;
    private double amount;
    private Restaurants restaurant;
    private Delivery delivery;

    public Order(String orderedItems) {
        this.orderID = nextOrderID++;
        this.orderedItems = orderedItems;
        this.orderStatus = "checking availability";
        this.amount = 0;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateAmount(double amount) {
        this.amount =amount;
        return this.amount;
    }

    public String placeOrder(String item) {
        this.orderedItems = item;
        this.orderStatus = "Placed";
        return "Order placed successfully";
    }

    public String cancelOrder() {
        this.orderStatus = "Cancelled";
        return "Order cancelled: " + this.orderedItems;
    }

    public String confirmOrder() {
        this.orderStatus = "Confirmed";

        if (restaurant != null) {
            return restaurant.receiveOrder(orderID);
        }

        return "Order confirmed";
    }

    public int getOrderID() {
        return orderID;
    }

    public void saveOrder() {
        try {
            FileWriter fw = new FileWriter("orders.txt", true);
            

            fw.write(orderID + "," + orderedItems + "," + amount + "," + orderStatus+"\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
    public void printReceipt(String restaurantName, ArrayList<Menu> cart, String paymentMethod) {
        System.out.println("\n===== ORDER RECEIPT =====");
        System.out.println("Order ID:    " + orderID);
        System.out.println("Restaurant: " + restaurantName);
        System.out.println("Items:");
        for (Menu m : cart) {
            System.out.println("  - " + m.getItemName() + "     ₹" + m.getPrice());
        }
        System.out.println("-------------------------");
        System.out.println("Total:      ₹" + amount);
        System.out.println("Payment:    " + paymentMethod);
        System.out.println("Status:     " + orderStatus);
        System.out.println("=========================");
    }
    private static int loadLastOrderID() {
        try {
            File file = new File("orders.txt");
            if (!file.exists()) return 101;

            Scanner sc = new Scanner(file);
            int ordercount = 0;

            while (sc.hasNextLine()) {
                sc.nextLine();
                ordercount++;
            }

            sc.close();
            return 100 + ordercount + 1; 
        } catch (Exception e) {
            return 101;
        }
    }
    }
