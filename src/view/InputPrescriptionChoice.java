package view;

/**
 * Handles user input for selecting a prescription from a list of choices.
 * This class extends {@link InputIntChoice} to inherit the functionality for getting
 * an integer choice from the user and is specifically tailored for prescription choices.
 * It ensures that the user's input is valid and falls within the specified range.
 * 
 */

public class InputPrescriptionChoice extends InputIntChoice{
	 /**
     * Constructor to initialize the input choice range for prescriptions.
     * 
     * @param no the number of prescription choices available.
     */

	public InputPrescriptionChoice(int no) {
		super(no);
	}

	 /**
     * Prompts the user to select a prescription and returns the selected choice.
     * 
     * @return the integer choice made by the user for a prescription.
     */
	
	public int getPrescription() {
		return getIntChoice();
	}
}
