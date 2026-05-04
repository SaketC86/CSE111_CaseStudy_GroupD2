package OnlineFoodSystem;

public class Delivery {
    private String agentName;
    private String mobileNumber;
    private String currentLocation;
    private int vehicleNumber;
    private String availabilityStatus;

    private Order order;

    public Delivery(String agentName, String mobileNumber, String currentLocation, int vehicleNumber, String availabilityStatus) {
        this.agentName = agentName;
        this.mobileNumber = mobileNumber;
        this.currentLocation = currentLocation;
        this.vehicleNumber = vehicleNumber;
        this.availabilityStatus = availabilityStatus;
    }

    public void assignOrder(Order order) {
        this.order = order;
    }

    public String acceptDelivery(String orderID) {
        return "Delivery accepted for Order ID: " + orderID;
    }

    public String updateLocation(String location) {
        this.currentLocation = location;
        return "Location updated to: " + location;
    }

    public String markDelivered(String status) {
        return "Order delivery status: " + status;
    }
    public void trackOrder(String orderID) {
        System.out.println("Tracking Order ID: " + orderID);
        System.out.println("Agent: " + agentName);
        System.out.println("Mobile: " + mobileNumber);
        System.out.println("Vehicle: " + vehicleNumber);
        System.out.println("Status: " + availabilityStatus);
        System.out.println("Location: " + currentLocation);
    }
    public String makePayment(double amount) {
        return "₹" + amount + " paid";
    }
}