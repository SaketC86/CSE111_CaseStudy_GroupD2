package OnlineFoodSystem;
import java.util.ArrayList;

public class Menu {

    private String itemName;
    private double price;
    private String category;
    private boolean availability;

    public Menu(String itemName, double price,
                String category, boolean availability) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.availability = availability;
    }

    public String displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Available: " + availability);
        return "Shown";
    }

    public static void displayMenu(ArrayList<Menu> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            Menu m = menuList.get(i);
            System.out.println((i + 1) + ". " + m.getItemName() + " - ₹" + m.getPrice());
        }
    }

    public String getItemName(){
    	return itemName;
    	}
    public double getPrice(){
    	return price;
    	}
}
