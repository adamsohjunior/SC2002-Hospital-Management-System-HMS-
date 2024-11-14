package view;

public class DoctorDisplayMenu implements DisplayMenu  {
	static public void display() {
		System.out.println("");
		String border = "+============================================+";
        
		System.out.println(border);
        System.out.printf("|%-44s|\n", "               Doctor Menu                ");
        System.out.println(border);
        System.out.printf("| %-42s |\n", "1) View Patient Medical Records");
        System.out.printf("| %-42s |\n", "2) Update Patient Medical Records");
        System.out.printf("| %-42s |\n", "3) View Personal Schedule");
        System.out.printf("| %-42s |\n", "4) Set Availability for Appointments");
        System.out.printf("| %-42s |\n", "5) Accept or Decline Appointment Requests");
        System.out.printf("| %-42s |\n", "6) View Upcoming Appointments");
        System.out.printf("| %-42s |\n", "7) Record Appointment Outcome");
        System.out.printf("| %-42s |\n", "8) View Inbox");
        System.out.printf("| %-42s |\n", "9) Logout");
        System.out.println(border);
		System.out.println("");
	}
}
