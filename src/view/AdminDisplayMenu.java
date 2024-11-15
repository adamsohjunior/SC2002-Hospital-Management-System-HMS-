package view;

/**
 * AdminDisplayMenu class for display
 */
public class AdminDisplayMenu implements Display{

    /**
     * static method to display menu for admin object
     */
    static public void display() {
        System.out.println("");
		String border = "+============================================+";
        
        System.out.println(border);
        System.out.printf("|%-44s|\n", "               Admin Menu               ");
        System.out.println(border);
        System.out.printf("| %-42s |\n", "1) View and Manage Staff");
        System.out.printf("| %-42s |\n", "2) View Appointment Details");
        System.out.printf("| %-42s |\n", "3) View and Manage Medication Inventory");
        System.out.printf("| %-42s |\n", "4) Approve Replenishment Requests");
        System.out.printf("| %-42s |\n", "5) Shut Down");
        System.out.printf("| %-42s |\n", "6) View Inbox");
        System.out.printf("| %-42s |\n", "7) Log Out");
        System.out.println(border);
        System.out.println("");
    } 
}
