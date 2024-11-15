package view;

/**
 * The StaffMDisplayMenu class provides a menu for managing staff in the system.
 * This menu offers options to add, update, remove, and display staff, as well as to exit the staff management interface.
 * 
 * <p>Example usage:</p>
 * <pre>
 * StaffMDisplayMenu.display();  // Displays the staff management menu
 * </pre>
 */

public class StaffMDisplayMenu implements DisplayMenu{

	/**
     * Displays the staff management menu with options for adding, updating, removing, and displaying staff,
     * as well as an option to exit the menu.
     * 
     * <p>The displayed options include:</p>
     * <ul>
     * <li>1) Add Staff</li>
     * <li>2) Update Staff</li>
     * <li>3) Remove Staff</li>
     * <li>4) Display Staff</li>
     * <li>5) Exit</li>
     * </ul>
     */
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Staff Menu			   ");
		System.out.println(border);
        System.out.println("1) Add Staff\r\n"
		    					+ "2) Update Staff\r\n"
		    					+ "3) Remove Staff\r\n"
		    					+ "4) Display Staff\r\n"
		    					+ "5) Exit\r");
        System.out.println(border);
        System.out.println("");
    } 
}
