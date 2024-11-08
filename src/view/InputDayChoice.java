package view;

public class InputDayChoice extends InputIntChoice{
	
	
	public InputDayChoice() {
		super(31);
	}
	
	
	
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