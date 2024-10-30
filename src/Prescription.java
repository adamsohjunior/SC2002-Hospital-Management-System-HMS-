package Classes;

public class Prescription {
	private String medicineName;
	private String status;
	
	public Prescription(String name) {
		this.medicineName = name;
		status = "Pending";
	}
	
	public void updateStatus() {
		status = "Completed";
	}
	
	public String getName() {
		return this.medicineName;
	}
	public String getStatus() {
		return this.status;
	}
	
}
