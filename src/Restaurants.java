package OnlineFoodSystem;

public class Restaurants {
    private String restaurantName;
    private String location;
    private double rating;
    private String menuItems;
    private double distance; 

    private Menu menu;

    public Restaurants(String restaurantName, String location, double rating, String menuItems, double distance) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.rating = rating;
        this.menuItems = menuItems;
        this.distance = distance;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public String receiveOrder(int orderID) {
        return "Order received , Order ID: " + orderID;
    }

    public String addMenuItem(String itemName) {
        this.menuItems += ", " + itemName;
        return "Added item to menu";
    }

    public String removeMenuItem(String itemName) {
        this.menuItems = this.menuItems.replace(itemName, "");
        return "Menu item removed successfully";
    }

    public void browseRestaurants(String enteredRestaurantName) {
        if (restaurantName.equals(enteredRestaurantName)) {
            System.out.println("Restaurant " + restaurantName);
            System.out.println("Location: " + location);
            System.out.println("Rating: " + rating);
        } else {
            System.out.println("Restaurant not found");
        }
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public double getDistance() {
        return distance;
    }
    public double getRating() {
        return rating;
    }
}