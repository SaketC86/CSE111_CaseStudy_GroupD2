package OnlineFoodSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Restaurants> resList = new ArrayList<>();
        ArrayList<Menu> menuList = new ArrayList<>();
        ArrayList<Menu> cart = new ArrayList<>();
        resList.add(new Restaurants("Spice Garden", "Indiranagar", 4.3, "Indian", 5.2));
        resList.add(new Restaurants("Food Hub", "MG Road", 4.6, "Chinese", 2.5));
        resList.add(new Restaurants("Tasty Treats", "BTM", 3.9, "Fast Food", 7.8));
        menuList.add(new Menu("Chicken Biryani", 250, "Main Course", true));
        menuList.add(new Menu("Noodles", 150, "Main Course", true));
        menuList.add(new Menu("Burger", 120, "Fast Food", true));
        menuList.add(new Menu("Paneer Tikka", 200, "Starter", true));
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        User user = new User(name, "Default Address", phone, name + "@mail.com");
        if (user.checkUser()) {
            System.out.println("Welcome back!");
        } else {
            user.saveUser();
            System.out.println("New user registered!");
        }
        Order order = new Order(101, "");
        Delivery agent = new Delivery("Ravi", "912345678", "City", 4521, "Available");
        Restaurants selectRes = null;
        int choice = 0;
        do {
            try {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. Select Restaurant");
                System.out.println("2. Add Item to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Place Order");
                System.out.println("5. Payment");
                System.out.println("6. Track Order");
                System.out.println("7. Feedback");
                System.out.println("8. Exit");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Available Restaurants:");
                        for (int i = 0; i < resList.size(); i++) {
                        	Restaurants r = resList.get(i);

                        	System.out.println(
                        	    (i + 1) + ". " +
                        	    r.getRestaurantName() +
                        	    "     ⭐" + r.getRating() +
                        	    "     |   " + r.getDistance() + " km away"
                        	);
                        }
                        System.out.print("Choose: ");
                        int rChoice = sc.nextInt();
                        sc.nextLine();
                        if (rChoice > 0 && rChoice <= resList.size()) {
                            selectRes = resList.get(rChoice - 1);
                            System.out.println("Selected: " + selectRes.getRestaurantName());
                            order.setRestaurant(selectRes);
                           
                        } else {
                            System.out.println("Invalid choice!");
                        }
                        break;
                    case 2:
                        if (selectRes == null) {
                            System.out.println("Select restaurant first!");
                            break;
                        }
                        System.out.println("Menu Items:");
                        for (int i = 0; i < menuList.size(); i++) {
                            Menu m = menuList.get(i);
                            System.out.println((i + 1) + ". " + m.getItemName() + " - ₹" + m.getPrice());
                        }
                        System.out.print("Choose item: ");
                        int mChoice = sc.nextInt();
                        sc.nextLine();
                        if (mChoice > 0 && mChoice <= menuList.size()) {
                            Menu selected = menuList.get(mChoice - 1);
                            cart.add(selected);
                            System.out.println(selected.getItemName() + " added to cart!");
                        } else {
                            System.out.println("Invalid choice!");
                        }
                        break;
                    case 3:
                        if (cart.isEmpty()) {
                            System.out.println("Cart is empty!");
                        } else {
                            System.out.println("Your Cart:");
                            double total = 0;
                            for (Menu m : cart) {
                                System.out.println("- " + m.getItemName() + " ₹" + m.getPrice());
                                total += m.getPrice();
                            }
                            System.out.println("Total: ₹" + total);
                        }
                        break;
                    case 4:
                        if (selectRes == null || cart.isEmpty()) {
                            System.out.println("Select restaurant and add items first!");
                            break;
                        }
                        user.setOrder(order);
                        double total = 0;
                        String items = "";
                        for (Menu m : cart) {
                            items += m.getItemName() + ", ";
                            total += m.getPrice();
                        }
                        order.placeOrder(items);
                        order.calculateAmount(total);
                        System.out.println("Ordering from: " + selectRes.getRestaurantName());
                        System.out.println("Items: " + items);
                        System.out.println("Total: ₹" + total);
                        System.out.println(order.confirmOrder(items));
                        order.saveOrder();
                        agent.assignOrder(order);
                        order.setDelivery(agent);
                       break;
                    case 5:
                        if (cart.isEmpty()) {
                            System.out.println("No order found!");
                            break;
                        }
                        double pay = 0;
                        for (Menu m : cart) {
                            pay += m.getPrice();
                        }
                        System.out.println("Select Payment Method:");
                        System.out.println("1. UPI");
                        System.out.println("2. Card");
                       System.out.println("3. Cash on Delivery");

                        int payChoice = sc.nextInt();
                        sc.nextLine();
                        String method = "";
                        switch (payChoice) {
                            case 1: method = "UPI"; break;
                            case 2: method = "Card"; break;
                            case 3: method = "Cash on Delivery"; break;
                            default: System.out.println("Invalid option"); break;
                        }
                        System.out.println(agent.makePayment(pay));
                        System.out.println(user.PaymentType(method));
                        break;
                    case 6:
                        if (cart.isEmpty()) {
                            System.out.println("No order placed yet!");
                            break;
                        }
                        System.out.println(agent.acceptDelivery(String.valueOf(order.getOrderID())));
                        agent.trackOrder(String.valueOf(order.getOrderID()));
                        System.out.println(agent.updateLocation("On the way"));
                        System.out.println(agent.markDelivered("Delivered"));
                        break;
                    case 7:
                        System.out.print("Enter feedback: ");
                        String fb = sc.nextLine();
                        System.out.println(user.Feedback(fb));
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        } while (choice != 8);
    }
}

