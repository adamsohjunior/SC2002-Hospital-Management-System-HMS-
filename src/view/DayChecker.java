package view;

/**
 * DayChecker class for validating the day of date
 */
public class DayChecker {
	/**
	 * list of months
	 */
	private String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	/**
	 * method to get the index of month from months List
	 * 
	 * @param month actual month
	 * @return the index of month, return -1 if not found
	 */
	public int getMonthIndex(String month) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(month)) {
                return i; 
            }
        }
        return -1; 
    }
	
	/**
	 * method to check if the day is valid for that month
	 * 
	 * @param month actual month
	 * @param day	actual day
	 * @return      TRUE if day is valid, FALSE if day not valid
	 */
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
