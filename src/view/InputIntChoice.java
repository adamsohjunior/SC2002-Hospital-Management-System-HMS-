package view;

import java.util.InputMismatchException;

/**
 * Handles user input for selecting a choice from a menu.
 * Implements the {@link InputInt} interface to ensure consistent integer input handling.
 * This class is designed to validate user input based on the number of available choices.
 */

public class InputIntChoice implements InputInt{
	private int numberOfChoice;
	
	/**
     * Constructs an InputIntChoice object with the specified number of choices.
     * 
     * @param no the number of valid choices for the menu
     */
	
	public InputIntChoice(int no) {
		numberOfChoice = no;
	}
	

	/**
     * Prompts the user to input a valid integer choice.
     * Ensures the input is within the range of 1 to numberOfChoice.
     * Handles invalid input types or out-of-range values gracefully by re-prompting the user.
     * 
     * @return the valid integer choice entered by the user
     */
	public int getIntChoice() {
		
		  int choice =-1;
		  boolean validity = false;
	      while (!validity) { 
	            try {
	            	System.out.println("Please input a choice: ");
	                choice = scan.nextInt(); 
	                if(choice>0 && choice<=numberOfChoice) {
	                
	 
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
			System.out.println("");
			return choice;
	}
}
