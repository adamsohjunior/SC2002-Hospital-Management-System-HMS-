package view;

/**
 * Displays the role selection menu in a structured format.
 * Implements the DisplayMenu interface to ensure consistency in displaying menu options.
 * This class is part of the view layer in the hospital management system.
 * 
 * The menu allows users to select roles such as Doctor, Pharmacist, or Admin.
 * 
 */

public class RoleDisplayMenu implements DisplayMenu{

    /**
     * Displays the menu options for selecting a staff role.
     * Provides choices for selecting the roles of Doctor, Pharmacist, or Admin.
     */
    
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Role Menu			   ");
		System.out.println(border);
        System.out.println("Select the Staff's Role\r\n"
                        + "1) Doctor\r\n"
                        + "2) Pharmacist\r\n"
                        + "3) Admin\r");
        System.out.println(border);
        System.out.println("");
    }
}
