package model;
/**
 * A Doctor Rating class just for the Doctor and his/her rating
 */
public class DoctorRating extends Rating{
	
	/**
	 * This will update the rating of the Doctor by calculation the average of his previous ratings
	 * 
	 */
	@override
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
