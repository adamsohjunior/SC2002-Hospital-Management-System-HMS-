package view;

/**
 * Displays the menu for updating prescription statuses in a structured format.
 * Implements the DisplayMenu interface to ensure consistency in displaying menu options.
 * This class is part of the view layer in the hospital management system.

 */
public class UpdatePresriptionStatusMenu implements DisplayMenu {

    /**
     * Displays the menu options for updating prescription statuses.
     * Provides the user with choices to update all prescription statuses, skip the update, or quit the menu.
     */
    
    static public void display() {
		System.out.println("");
		System.out.println("Do you wish to update all prescription status?\r\n"
                            + "1. Yes\r\n"
                            + "2. No\r\n"
                            + "3. Quit\r");
		System.out.println("");
	}
}
