package view;

/**
 * Class to prompt an input for a Day choice
 */
public class InputDayChoice extends InputIntChoice{
	/**
	 * Super constructor of InputIntChoice
	 */
	public InputDayChoice() {
		super(31);
	}
	
	/**
	 * To get an input from the user and return the day the user selected.
	 * Day selected by user will be checked for validity.
	 * @param month Month that the user selected
	 * @return Day that the user selected
	 */
	public int getDay(String month) {
		DayChecker dayChecker = new DayChecker();
		int choice =-1;
		boolean validDay;
		while (true) {
			choice = getIntChoice();
			validDay = dayChecker.dayCheck(month, choice);
			if(validDay == false) {
				System.out.println("Day does not exists! Enter an appropriate day!");
			}
			else {
				break;
			}
		}
		return choice;
	
	}
}