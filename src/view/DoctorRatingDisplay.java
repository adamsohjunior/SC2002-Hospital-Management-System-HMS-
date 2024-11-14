package view;

import java.util.ArrayList;
import java.util.Set;

import model.Doctor;

public class DoctorRatingDisplay implements DisplayMenu{
	public static void display(Set<Doctor> doctorList) {
		/*if (doctorList.size() == 0) {
			System.out.println("You have not seen any Doctors yet!");
			return;
		}*/
		System.out.println("");
		System.out.println("Doctor To Rate");
		System.out.println("==============================================");
		int i = 1;
		for(Doctor doctor : doctorList) {
			System.out.println(i+") "+doctor.getName());
			i++;
		}
		System.out.println("==============================================");
		System.out.println("");
		
		//MAKE THE DOCTOR LIST A SET? UPDATE PATIEN MENU UPDATE INTCHOICE UPDATE SWITCH
		
		
	}
}
