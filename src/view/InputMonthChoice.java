package view;
import java.util.InputMismatchException;

/**
 * Handles user input for selecting a month from a list of months.
 * Inherits from InputIntChoice to utilize the functionality of integer input validation.
 * This class provides a way for the user to input a valid month choice by selecting a number 
 * corresponding to a month (1-12).

 */
public class InputMonthChoice extends InputIntChoice{

	// Array of month abbreviations
	private String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	/**
     * Constructs an InputMonthChoice object with a preset range of valid choices (1-12).
     */
	public InputMonthChoice() {
		super(12);
	}
	
	 /**
     * Prompts the user to select a month by entering a valid integer choice (1-12).
     * The method converts the integer choice to its corresponding month abbreviation.
     * 
     * @return the abbreviation of the selected month (e.g., "JAN", "FEB", etc.)
     */
	
	public String getMonth() {
		int choice = getIntChoice();
		return months[choice-1];
	}
}


