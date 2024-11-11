package view;

import java.util.ArrayList;

import model.Appointment;

public class AppointmentsDisplay implements DisplayInfo {
	static public void display(ArrayList<Appointment> scheduledAppointments) {
		System.out.println("");
		System.out.println("Appointments");
		System.out.println("==============================================");
		for(int i=0;i<scheduledAppointments.size();i++) {
			System.out.println((i+1)+")Doctor: "+scheduledAppointments.get(i).getDoctor().getName());
			System.out.println("    Patient: "+scheduledAppointments.get(i).getPatient().getName());
			System.out.println("    Date: "+scheduledAppointments.get(i).getDate());
			System.out.println("    Time: "+scheduledAppointments.get(i).getTime());
			System.out.println("    Status: "+scheduledAppointments.get(i).getStatus());
			System.out.println("");
		}
		System.out.println("==============================================");
		System.out.println("");
	}
}
