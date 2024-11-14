package view;

public class PatientDisplayMenu implements DisplayMenu {
	static public void display() {
		System.out.println("");
		System.out.println("Patient Menu");
		System.out.println("==============================================");
		System.out.println("1) View Medical Record\r\n"
				+ "2) Update Personal Information\r\n"
				+ "3) View Available Appointment Slots\r\n"
				+ "4) Schedule an Appointment\r\n"
				+ "5) Reschedule an Appointment\r\n"
				+ "6) Cancel an Appointment\r\n"
				+ "7) View Scheduled Appointments\r\n"
				+ "8) View Past Appointment Outcome Records\r\n"
				+ "9) View Inbox\r\n"
				+ "10) Logout");
		System.out.println("==============================================");
		System.out.println("");
	}
}
