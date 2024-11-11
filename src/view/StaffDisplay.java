package view;

import model.User;
import java.util.ArrayList;

public class StaffDisplay implements DisplayInfo{
    public static void display(ArrayList<User> staffList) {
        System.out.printf("%-15s %-10s %-10s %-5s %-15s%n", "Name", "Gender", "ID", "Age", "Role");
        System.out.println("-------------------------------------------------------");

        // Display staff details
        for (User staff : staffList) {
            String role = staff.getUserId();
            if (role.charAt(0) == 'D') { role = "Doctor";}
            if (role.charAt(0) == 'P') { role = "Pharmacist";}
            if (role.charAt(0) == 'A') { role = "Administrator";}
            System.out.printf("%-15s %-10s %-10s %-5d %-15s%n", 
                staff.getName(), 
                staff.getGender(), 
                staff.getUserId(), 
                staff.getAge(),
                role);
        }
    }
}
