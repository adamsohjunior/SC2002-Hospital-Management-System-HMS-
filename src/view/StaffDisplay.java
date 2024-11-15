package view;

import model.User;
import model.Doctor;
import java.util.ArrayList;

public class StaffDisplay implements DisplayInfo{
    public static void display(ArrayList<User> staffList) {
        String rating = "0";
        String border = "==================================================================";
        System.out.printf("%-15s %-10s %-10s %-5s %-15s %-7s%n", "Name", "Gender", "ID", "Age", "Role", "Rating");
        System.out.println(border);

        // Display staff details
        for (User staff : staffList) {
            String role = staff.getUserId();
            if (role.charAt(0) == 'D') { 
                role = "Doctor"; 
                rating = Float.toString(((Doctor)staff).getRating().getRating()) + "/5";
            }
            if (role.charAt(0) == 'P') { role = "Pharmacist"; rating = "NA";}
            if (role.charAt(0) == 'A') { role = "Administrator"; rating = "NA";}
            System.out.printf("%-15s %-10s %-10s %-5d %-15s %-7s%n", 
                staff.getName(), 
                staff.getGender(), 
                staff.getUserId(), 
                staff.getAge(),
                role, rating);
        }

        System.out.println(border);
    }
}
