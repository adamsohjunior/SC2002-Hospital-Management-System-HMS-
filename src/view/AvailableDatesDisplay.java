package view;

import java.util.ArrayList;

import model.Availability;

public class AvailableDatesDisplay {
	static public void display(ArrayList<Availability> availableDates) {
		System.out.println("");
		System.out.println("Available Dates");
		System.out.println("==============================================");
		for (int i=0;i<availableDates.size();i++) {
			if(availableDates.get(i).getStatus().equals("Available")) {
				System.out.println((i+1)+")  Doctor: "+availableDates.get(i).getDoctor().getName());
				System.out.println("    Date: "+availableDates.get(i).getDate());
				System.out.println("    Time: "+availableDates.get(i).getTime());
				System.out.println("");
			}
		}
		System.out.println("==============================================");
		System.out.println("");
	}
}
