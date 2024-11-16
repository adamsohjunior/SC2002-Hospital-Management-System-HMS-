package view;

import java.util.Set;

import model.Doctor;
/**
 * DoctorRating Class to be displayed, displays doctors to be rated
 */
public class DoctorRatingDisplay implements DisplayMenu{
	/**
	 * Displays doctors to be rated
	 * @param doctorList List of doctors to be rated
	 */
	public static void display(Set<Doctor> doctorList) {
		/*if (doctorList.size() == 0) {
			System.out.println("You have not seen any Doctors yet!");
			return;
		}*/
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n","		Doctor to Rate			   ");
		System.out.println(border);
		int i = 1;
		for(Doctor doctor : doctorList) {
			System.out.println(i+") "+doctor.getName());
			i++;
		}
		System.out.println(border);
		System.out.println("");
		
		//MAKE THE DOCTOR LIST A SET? UPDATE PATIEN MENU UPDATE INTCHOICE UPDATE SWITCH
		
		
	}
}
