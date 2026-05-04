package OnlineFoodSystem;

import java.io.*;

public class Order {
    private int orderID;
    private String orderStatus;
    private String orderedItems;
    private int amount;

    private Restaurants restaurant;
    private Delivery delivery;

    public Order(int orderID, String orderedItems) {
        this.orderID = orderID;
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
        this.amount = (int) amount;
        return this.amount;
    }

    public String updateStatus(String status) {
        this.orderStatus = status;
        return "Order status updated to: " + status;
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

    public String confirmOrder(String itemChecked) {
        this.orderStatus = "Confirmed";

        if (restaurant != null) {
            System.out.println(restaurant.receiveOrder(orderID));
        }

        return "Order confirmed: " + itemChecked;
    }

    public int getOrderID() {
        return orderID;
    }

    public void saveOrder() {
        try {
            FileWriter fw = new FileWriter("orders.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(orderID + "," + orderedItems + "," + amount + "," + orderStatus);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}