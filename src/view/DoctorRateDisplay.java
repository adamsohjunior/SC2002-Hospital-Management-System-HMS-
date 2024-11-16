package view;

import model.Doctor;
/**
 * DoctorRate Class to be displayed
 */
public class DoctorRateDisplay implements DisplayInfo {
	/**
	 * static method to display rating system for a Doctor
	 * @param doc Doctor to be rated
	 */
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
