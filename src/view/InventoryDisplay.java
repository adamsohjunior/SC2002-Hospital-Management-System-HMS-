package view;

import model.Inventory;

/**
 * Provides a utility to display inventory information in a structured format.
 * Implements the DisplayInfo interface to ensure consistency in displaying details.
 * This class is part of the view layer in the hospital management system.
 * 
 */

public class InventoryDisplay implements DisplayInfo {

	/**
     * Displays the details of a given Inventory object in a readable format.
     * 
     * @param inventory the inventory object whose details are to be displayed.
     */

    static public void display(Inventory inventory) {
		System.out.println("");
		//System.out.println("Current Inventory Information: ");
		//System.out.println("==============================================");
		System.out.println("Medicine Name: " +  inventory.getName());
		System.out.println("Stock Available: " + inventory.getStock());
        System.out.println("Stock Status: " + inventory.getStatus());
		System.out.println("Request Status: " + inventory.getreqStatus());
		//System.out.println("==============================================");
		System.out.println("");
    }
}
