package view;

/**
 * Displays the menu for submitting replenishment requests in a structured format.
 * Implements the DisplayMenu interface to ensure consistency in displaying menu options.
 * This class is part of the view layer in the hospital management system.
 */

public class ReplenishmentRequestMenu implements DisplayMenu {

	/**
     * Displays the menu options for submitting a replenishment request.
     * Provides the user with a simple choice to either confirm or cancel the request.
     */
	
    static public void display() {
		System.out.println("");

		System.out.println("Submit replenishment request?\r\n"
                            + "1. Yes\r\n"
                            + "2. No\r");

		System.out.println("");
	}
}
