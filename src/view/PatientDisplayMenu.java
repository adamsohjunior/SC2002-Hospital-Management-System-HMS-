package view;

public class PatientDisplayMenu implements DisplayMenu {
	static public void display() {
		System.out.println("");
		String border = "+============================================+";

        System.out.println(border);
        System.out.printf("|%-44s|\n", "               Patient Menu               ");
        System.out.println(border);
        System.out.printf("| %-42s |\n", "1) View Medical Record");
        System.out.printf("| %-42s |\n", "2) Update Personal Information");
        System.out.printf("| %-42s |\n", "3) View Available Appointment Slots");
        System.out.printf("| %-42s |\n", "4) Schedule an Appointment");
        System.out.printf("| %-42s |\n", "5) Reschedule an Appointment");
        System.out.printf("| %-42s |\n", "6) Cancel an Appointment");
        System.out.printf("| %-42s |\n", "7) View Scheduled Appointments");
        System.out.printf("| %-42s |\n", "8) View Past Appointment Outcome Records");
        System.out.printf("| %-42s |\n", "9) View Inbox");
        System.out.printf("| %-42s |\n", "10) Logout");
        System.out.println(border);
		System.out.println("");
	}
}
