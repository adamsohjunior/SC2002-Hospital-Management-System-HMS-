package view;
import java.util.InputMismatchException;

public class InputMonthChoice extends InputIntChoice{
	private String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	
	public InputMonthChoice() {
		super(12);
	}
	
	
	public String getMonth() {
		int choice = getIntChoice();
		return months[choice-1];
	}
}


