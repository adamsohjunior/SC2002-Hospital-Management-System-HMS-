package view;

import java.util.ArrayList;
import model.Availability;
import model.Inventory;

/**
 * The MedicineDisplay class is responsible for displaying a list of medications available in the inventory.
 * It formats and prints each medication name from a list of Inventory objects, showing the available medications 
 * in a readable list format.
 * 
 * <p>Example usage:</p>
 * <pre>
 * ArrayList<Inventory> medicines = new ArrayList<>();
 * // Add Inventory objects to the list
 * MedicineDisplay.display(medicines);  // Display the list of medications
 * </pre>
 * 
 * @see Inventory
 */

public class MedicineDisplay implements DisplayInfo {

	 /**
     * Displays a list of medication names from the provided inventory storage.
     * Each medication is displayed with a number corresponding to its index in the list.
     * 
     * @param storage the {@link ArrayList} of {@link Inventory} objects containing the medications to be displayed.
     */
	
	static public void display(ArrayList<Inventory> storage) {
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n","		Medication			   ");
		System.out.println(border);
		for (int i=0;i<storage.size();i++) {
				System.out.println((i+1)+") "+storage.get(i).getName());
		}
		System.out.println(border);
		System.out.println("");
	}	
}
