package view;

public class PharmacistDisplayMenu implements DisplayMenu {
    static public void display() {
		System.out.println("");
		System.out.println("Pharmacist Menu");
		System.out.println("==============================================");
		System.out.println("1) View Appointment Outcome Record\r\n"
                            + "2) Update Prescription Status\r\n"
                            + "3) View Medication Inventory\r\n"
                            + "4) Submit Replenishment Request\r\n"
                            + "5) Logout\r");
		System.out.println("==============================================");
		
	}
}
