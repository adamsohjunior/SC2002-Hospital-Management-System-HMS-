package view;


/**
 * The InputTimeChoice class extends the InputIntChoice class and handles user input for selecting a time slot.
 * This class provides a way to prompt the user to choose from a predefined set of time choices (from "8AM" to "5PM").
 * It uses the parent class InputIntChoice to handle integer-based input validation and selection.
 * 
 * <p>Example usage:</p>
 * <pre>
 * InputTimeChoice input = new InputTimeChoice();
 * String time = input.getTime();
 * </pre>
 * 
 * @see InputIntChoice
 * @see InputInt
 */

public class InputTimeChoice extends InputIntChoice{

	/**
     * An array of time slots available for the user to choose from, ranging from "8AM" to "5PM".
     */

	private String[] time = {"8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM"};
	
	/**
     * Constructor that initializes the parent {@code InputIntChoice} class with a predefined number of choices (10).
     */
	public InputTimeChoice() {
		super(10);
	}
	
	
	/**
     * Prompts the user to select a time slot and returns the corresponding time as a string.
     * 
     * @return the time slot chosen by the user, represented as a string.
     */
	public String getTime() {
		int choice = getIntChoice();
		return time[choice-1];
	}
}