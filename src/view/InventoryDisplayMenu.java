package view;

/**
 * Displays the inventory management menu in a structured format.
 * Implements the DisplayMenu interface to ensure consistency in displaying menu options.
 * This class is part of the view layer in the hospital management system.
 * 
 * It provides options for adding, updating, and removing stocks, 
 * setting alert levels, approving replenishment requests, displaying inventory details, and exiting.
 * 
 */

public class InventoryDisplayMenu implements DisplayMenu {

	/**
     * Displays the menu options for inventory management.
     * The menu includes operations to manage stock levels, alert thresholds, and replenishment requests.
     */
	
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Inventory Menu		   ");
		System.out.println(border);
        System.out.println("1) Add Stocks\r\n"
		    					+ "2) Update Stocks\r\n"
		    					+ "3) Remove Stocks\r\n"
		    					+ "4) Update Alert Line\r\n"
		    					+ "5) Approve Replenishment Requests\r\n"
                                + "6) Display Inventory\r\n"
		    					+ "7) Exit\r");
        System.out.println(border);
        System.out.println("");
    }
}
