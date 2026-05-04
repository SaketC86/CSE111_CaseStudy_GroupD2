package OnlineFoodSystem;

public class Menu {
    private String itemName;
    private int price;
    private String category;
    private boolean availability;

    public Menu(String itemName, int price, String category, boolean availability) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.availability = availability;
    }

    public String displayItem(){
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Available: " + availability);
        return "Shown";
    }
    public String updateAvailability(boolean availability) {
        this.availability = availability;
        return "Availability updated";
    }

    public double updatePrice(double price) {
        this.price = (int) price;
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }
}