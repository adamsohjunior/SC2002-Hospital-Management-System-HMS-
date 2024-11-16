package view;

import java.util.ArrayList;

import model.Appointment;

/**
 * AppointmentDisplay class for display
 */
public class AppointmentsDisplay implements DisplayInfo {

	/**
	 * static method to display scheduled appointments
	 * 
	 * @param scheduledAppointments the list of all scheduled appointments
	 */
	static public void display(ArrayList<Appointment> scheduledAppointments) {
		String border = "----------------------------------------------";
		System.out.printf("%-44s\n", "	Appointment		   ");
		System.out.println(border);
		System.out.println("");
		for(int i=0;i<scheduledAppointments.size();i++) {
			System.out.println((i+1)+")  Doctor: "+scheduledAppointments.get(i).getDoctor().getName());
			System.out.println("    Patient: "+scheduledAppointments.get(i).getPatient().getName());
			System.out.println("    Date: "+scheduledAppointments.get(i).getDate());
			System.out.println("    Time: "+scheduledAppointments.get(i).getTime());
			System.out.println("    Status: "+scheduledAppointments.get(i).getStatus());
			System.out.println("");
		}
		System.out.println(border);
		System.out.println("");
	}
}
