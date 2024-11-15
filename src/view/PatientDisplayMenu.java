package view;

/**
 * The PatientDisplayMenu class is responsible for displaying the menu of available actions for a patient.
 * It provides the patient with options to view medical records, schedule and manage appointments, and more.
 * 
 * <p>Example usage:</p>
 * <pre>
 * PatientDisplayMenu.display();  // Displays the menu with options for the patient
 * </pre>
 */
public class PatientDisplayMenu implements DisplayMenu {

    /**
     * Displays the patient menu, showing a list of actions that the patient can perform.
     * Each option is presented with a corresponding number for easy selection.
     * The menu includes options for viewing medical records, scheduling or rescheduling appointments,
     * and interacting with other patient services.
     */
    
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
        System.out.printf("| %-42s |\n", "10) Rate a Doctor");
        System.out.printf("| %-42s |\n", "11) Logout");
        System.out.println(border);
		System.out.println("");
	}
}
