package model;

public class Rating {
	private float rating = 0;
	private int count = 0;
	
	public void updateRating(int feedback) {
		if(getCount() == 0) {
			setCount(1);
		}
		else {
			count++;
		}
		
		rating = feedback;
    }

    public float getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }
    
    public void setRating(float rating) {
    	this.rating = rating;
    }
    
    public void setCount(int count) {
    	this.count = count;
    }
}
