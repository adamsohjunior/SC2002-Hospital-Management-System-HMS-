package Classes;

public class Availability {
	private Doctor doctor;
	private String date;
	private String time;
	private String status;
	
	public Availability(Doctor doc, String date, String time) {
		doctor = doc;
		this.date = date;
		this.time = time;
		status ="Available";
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String newStatus) {
		this.status = newStatus;
	}
}
