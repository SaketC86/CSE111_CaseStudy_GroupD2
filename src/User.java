package OnlineFoodSystem;

import java.io.*;
import java.util.*;

public class User {
    
    private String username;
    private String deliveryAddress;
    private String phoneNumber;
    private String feedback;
    private String email;
    private Order order;
    
    public static User login(String name, String phone) {
        User user = new User(name, "Default Address", phone, name + "@mail.com");
        if (user.checkUser()) {
            System.out.println("\nWelcome back!");
        } else {
            user.saveUser();
            System.out.println("\nNew user registered!");
        }
        return user;
    }
  
    public User(String username, String deliveryAddress, String phoneNumber, String email) {
        this.username = username;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.feedback = "";
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public boolean checkUser() {
        try {
            File file = new File("users.txt");
            if (!file.exists()) return false;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(username) && data[1].equals(phoneNumber)) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return false;
    }
    public void saveUser() {
        try {
            FileWriter fw = new FileWriter("users.txt", true);
            fw.write(username + "," + phoneNumber+"\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public String Feedback(int choice) {
        switch (choice) {
            case 1: this.feedback = "Excellent"; break;
            case 2: this.feedback = "Average"; break;
            case 3: this.feedback = "Bad"; break;
            default: return "Invalid feedback option!";
        }
        return "Feedback submitted: " + this.feedback;
    }
    public String PaymentType(String type) {
        return "Selected Payment Method: " + type;
    } 

    public void displayUserDetails() {
        System.out.println("Username: " + username);
        System.out.println("Address: " + deliveryAddress);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Feedback: " + feedback);
    }
}
