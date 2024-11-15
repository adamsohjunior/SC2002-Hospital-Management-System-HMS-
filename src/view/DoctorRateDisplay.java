package view;

import model.Doctor;

public class DoctorRateDisplay implements DisplayInfo {
	public static void display(Doctor doc) {
		System.out.println("");
		System.out.println("Doctor To Be Rated");
		System.out.println("==============================================");
		System.out.println("Please rate the Dr "+doc.getName()+" out of 5 Rating");
		System.out.println("1 - 5");
		System.out.println("==============================================");
		System.out.println("");
	
	}

}
