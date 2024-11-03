import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator extends User {
    private Scanner scan = new Scanner(System.in);

    public Administrator(String id, String name, int age, String gender) {
        super(id, name, age, gender);
    }

    public void displayMenu() {
        int choice=-1;
		boolean validity = false;
		
		do{
			validity = false;
			while (!validity) { 
				try {
					System.out.println("1) View and Manage Staff\r\n"
							+ "2) View Appointment Details\r\n"
							+ "3) View and Manage Medication Inventory\r\n"
							+ "4) Approve Replenishment Requests"
							+ "5) Logout\r\n");
					System.out.print("Please enter your choice: ");
					choice = scan.nextInt(); 
					if(choice > 0 && choice <= 5) {
						validity = true;
					}
					else {
						System.out.println("Please input a choice that is valid.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter an appropriate choice.");
					scan.next(); 
				}
			}
			/* clear the enter key */
			scan.nextLine(); 
			switch(choice) {
			case 1:
				manageStaff();
				break;
			case 2:
				printInfoForAdmin();
				break;
			case 3:
				InventoryManagement();
				break;
			case 4:
				approveRequest();
				break;
			}
			case 5:
				break;
		} while (choice != 5);
		
		// scan.close();
    }

    
}

