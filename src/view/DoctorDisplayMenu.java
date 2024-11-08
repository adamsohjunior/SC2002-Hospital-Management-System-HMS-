package view;

public class DoctorDisplayMenu implements DisplayMenu  {
	static public void display() {
		System.out.println("");
		System.out.println("Doctor Menu");
		System.out.println("==============================================");
		System.out.println("1)View Patient Medical Records\r\n"
				+ "2) Update Patient Medical Records\r\n"
				+ "3) View Personal Schedule\r\n"
				+ "4) Set Availability for Appointments\r\n"
				+ "5) Accept or Decline Appointment Requests\r\n"
				+ "6) View Upcoming Appointments\r\n"
				+ "7) Record Appointment Outcome\r\n"
				+ "8) Logout\r\n");
		System.out.println("==============================================");
		System.out.println("");
	}
}
