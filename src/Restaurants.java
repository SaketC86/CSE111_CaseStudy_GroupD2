package OnlineFoodSystem;

import java.util.ArrayList;

public class Restaurants {

    private String restaurantName;
    private String location;
    private double rating;
    private double distance;
    private ArrayList<Menu> menuList;
    public Restaurants(String restaurantName, String location,
                       double rating, double distance) {

        this.restaurantName = restaurantName;
        this.location = location;
        this.rating = rating;
        this.distance = distance;

        
        this.menuList = new ArrayList<>();
    }

 
    public void addMenuItem(Menu item) {
        menuList.add(item);
    }

  
    public ArrayList<Menu> getMenuList() {
        return menuList;
    }


    public String receiveOrder(int orderID) {
        return "Order received, Order ID: " + orderID +
               " at " + restaurantName;
    }
    public static ArrayList<Restaurants> getRestaurants() {
        ArrayList<Restaurants> resList = new ArrayList<>();

   
        Restaurants r1 = new Restaurants("McDonald's", "MG Road", 4.2, 1.8);
        r1.addMenuItem(new Menu("Veg Burger", 99, "Fast Food", true));
        r1.addMenuItem(new Menu("Chicken Burger", 149, "Fast Food", true));

    
        Restaurants r2 = new Restaurants("Domino's Pizza", "Indiranagar", 4.1, 2.5);
        r2.addMenuItem(new Menu("Cheese Pizza", 349, "Pizza", true));
        r2.addMenuItem(new Menu("Paneer Pizza", 399, "Pizza", true));

  
        Restaurants r3 = new Restaurants("Paradise Biryani", "Jubilee Hills", 4.7, 3.2);
        r3.addMenuItem(new Menu("Dum Biryani", 299, "Biryani", true));
        r3.addMenuItem(new Menu("Chiken 65", 249, "Starter", true));
        

  
        Restaurants r4 = new Restaurants("KFC", "Brigade Road", 4.3, 4.0);
        r4.addMenuItem(new Menu("Fried Chicken", 179, "Starter", true));


        Restaurants r5 = new Restaurants("Subway", "Koramangala", 4.0, 3.7);
        r5.addMenuItem(new Menu("Veg Sandwich", 149, "Sandwich", true));
        r5.addMenuItem(new Menu("Chicken Sandwich", 149, "Sandwich", true));

        resList.add(r1);
        resList.add(r2);
        resList.add(r3);
        resList.add(r4);
        resList.add(r5);

        return resList;
    }

  
    public static void browseRestaurants(ArrayList<Restaurants> resList) {
        for (int i = 0; i < resList.size(); i++) {
            Restaurants r = resList.get(i);
            System.out.println(
                (i + 1) + ". " +
                r.restaurantName +
                "   *" + r.rating +
                "   |   " + r.distance + " km away"
            );
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
