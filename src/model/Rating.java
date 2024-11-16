package model;

/**
 * This is a Rating class that will contain the rating attribute, the number of times being rated in count and methods to update this 
 * this rating value for a user
 */
public class Rating {
	/**
	 * Rating for user
	 */
	private float rating = 0;
	/**
	 * Number of times rated
	 */
	private int count = 0;
	/**
	 * To update User's rating by updating it to the latest rating
	 * @param feedback
	 */
	public void updateRating(int feedback) {
		if(getCount() == 0) {
			setCount(1);
		}
		else {
			count++;
		}
		
		rating = feedback;
    }
	/**
	 * Get current User's rating
	 * @return User's Rating
	 */
    public float getRating() {
        return rating;
    }
	/**
	 * Get numbe of times being rated
	 * @return count
	 */
    public int getCount() {
        return count;
    }
    /**
	 * Set User's rating
	 * @param rating Rating
	 */
    public void setRating(float rating) {
    	this.rating = rating;
    }
    /**
	 * Set User's number of time being rated
	 * @param count count
	 */
    public void setCount(int count) {
    	this.count = count;
    }
}
