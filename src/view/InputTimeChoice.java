package view;

public class InputTimeChoice extends InputIntChoice{
	private String[] time = {"8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM"};
	
	
	public InputTimeChoice() {
		super(10);
	}
	
	
	
	public String getTime() {
		int choice = getIntChoice();
		return time[choice-1];
	}
}