package view;

public class UpdatePresriptionStatusMenu implements DisplayMenu {
    static public void display() {
		System.out.println("");
		System.out.println("Update Prescription Status Menu");
		System.out.println("==============================================");
		System.out.println("Do you wish to update all prescription status?\r\n"
                            + "1. Yes\r\n"
                            + "2. No\r\n"
                            + "3. Quit\r\n");
		System.out.print("Please enter your choice: ");
		System.out.println("==============================================");
		System.out.println("");
	}
}
