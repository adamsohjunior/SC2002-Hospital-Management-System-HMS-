package view;

import model.Doctor;

public class DoctorRateDisplay implements DisplayInfo {
	public static void display(Doctor doc) {
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Doctor to be Rated			   ");
		System.out.println(border);
		System.out.println("Please rate the Dr "+doc.getName()+" out of 5 Rating");
		System.out.println("1 - 5");
		System.out.println(border);
		System.out.println("");
	
	}

}
