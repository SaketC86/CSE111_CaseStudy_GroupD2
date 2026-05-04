package OnlineFoodSystem;

import java.io.*;
import java.util.*;

public class User {
    
    private String username;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private String feedback;

    private Order order;
  
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

  

    public String Login(String enteredUsername, String enteredPhoneNo) {
        if (this.username.equals(enteredUsername) && this.phoneNumber.equals(enteredPhoneNo)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
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
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(username + "," + phoneNumber);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public String Feedback(String feedback) {
        this.feedback = feedback;
        return "Feedback submitted: " + feedback;
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