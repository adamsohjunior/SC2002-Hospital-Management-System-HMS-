package model;

public class DoctorRating extends Rating{
	
	public void updateRating(int feedback) {
		
		if(getCount() == 0) {
			setCount(1);
		}
		else {
			setCount(getCount()+1);
		}
		
		
		setRating((getRating()+feedback)/getCount());
		
    }
}
