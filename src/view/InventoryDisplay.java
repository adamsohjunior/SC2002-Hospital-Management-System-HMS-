package view;

import model.Inventory;

public class InventoryDisplay {
    static public void display(Inventory inventory) {
		System.out.println("");
		//System.out.println("Current Inventory Information: ");
		//System.out.println("==============================================");
		System.out.println("Medicine Name: " +  inventory.getName());
		System.out.println("Stock Available: " + inventory.getStock());
        System.out.println("Stock Status: " + inventory.getStatus());
		//System.out.println("==============================================");
		System.out.println("");
    }
}
