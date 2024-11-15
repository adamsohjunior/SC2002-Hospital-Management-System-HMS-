package view;

import java.util.ArrayList;

import model.Availability;
import model.Inventory;

public class MedicineDisplay implements DisplayInfo {
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
