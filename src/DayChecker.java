package input;

public class DayChecker {
	private String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	public int getMonthIndex(String month) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(month)) {
                return i; 
            }
        }
        return -1; 
    }
	
	public boolean dayCheck(String month, int day) {
		int monthIndex = getMonthIndex(month);
		int totalDays;
			switch (monthIndex) {
	        case 3: case 5: case 8: case 10:
	        	totalDays = 30; // April, June, September, November
	            break;
	        case 1:
	        	totalDays = 28; // February
	            break;
	        default:
	        	totalDays = 31; // January, March, May, July, August, October, December
	    }
		
		if(day>totalDays) {
			return false;
		}
		return true;
	}
	
}
