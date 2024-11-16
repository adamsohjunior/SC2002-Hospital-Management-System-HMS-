package view;

import model.User;
import model.Doctor;
import java.util.ArrayList;


/**
 * The StaffDisplay class is responsible for displaying a list of staff members.
 * It presents information about the staff members, including their name, gender, ID, age, role, and rating.
 * The information is displayed in a well-formatted table, with special treatment for doctors' ratings.
 * 
 * <p>Example usage:</p>
 * <pre>
 * ArrayList<User> staffList = new ArrayList<>();
 * StaffDisplay.display(staffList);  // Displays the staff information
 * </pre>
 */

public class StaffDisplay implements DisplayInfo{

    /**
     * Displays a list of staff members, including their name, gender, ID, age, role, and rating (for doctors).
     * The list is formatted in a table, with a header and a border separating the entries.
     *
     * @param staffList An ArrayList containing the {@link User} objects representing the staff.
     * The list can contain users of various roles, including doctors, pharmacists, and administrators.
     */

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
