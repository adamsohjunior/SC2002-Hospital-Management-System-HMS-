package view;

/**
 * Displays the pharmacist menu in a structured format.
 * Implements the DisplayMenu interface to ensure consistency in displaying menu options.
 * This class is part of the view layer in the hospital management system.
 */

public class PharmacistDisplayMenu implements DisplayMenu {

    /**
     * Displays the menu options available to the pharmacist in a formatted layout.
     * The menu includes options such as viewing appointment outcomes, updating prescription status,
     * managing inventory, submitting replenishment requests, and logging out.
     */
    
    static public void display() {
		System.out.println("");
		String border = "+============================================+";

        System.out.println(border);
        System.out.printf("|%-44s|\n", "           Pharmacist Menu                ");
        System.out.println(border);
        System.out.printf("| %-42s |\n", "1) View Appointment Outcome Record");
        System.out.printf("| %-42s |\n", "2) Update Prescription Status");
        System.out.printf("| %-42s |\n", "3) View Medication Inventory");
        System.out.printf("| %-42s |\n", "4) Submit Replenishment Request");
        System.out.printf("| %-42s |\n", "5) View Inbox");
        System.out.printf("| %-42s |\n", "6) Logout");
        System.out.println(border);
		System.out.println("");
	}
}
