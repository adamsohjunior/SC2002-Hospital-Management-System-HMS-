package view;

import java.util.ArrayList;

import model.Availability;
import model.Inventory;

public class MedicineDisplay implements DisplayInfo {
	static public void display(ArrayList<Inventory> storage) {
		System.out.println("");
		System.out.println("Medications");
		System.out.println("==============================================");
		for (int i=0;i<storage.size();i++) {
				System.out.println((i+1)+") "+storage.get(i).getName());
		}
		System.out.println("==============================================");
		System.out.println("");
	}	
}
