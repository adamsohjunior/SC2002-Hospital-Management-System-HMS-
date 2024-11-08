package view;

public class ReplenishmentRequestMenu implements DisplayMenu {
    static public void display() {
		System.out.println("");
		System.out.println("Replenishment Request Menu");
		System.out.println("==============================================");
		System.out.println("Submit replenishment request?\r\n"
                            + "1. Yes\r\n"
                            + "2. No\r\n");
		System.out.print("Please enter your choice: ");
		System.out.println("==============================================");
		System.out.println("");
	}
}
