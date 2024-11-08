package model;
public class Prescription {
	private String medicineName;
	private String status;
	
	public Prescription(String name) {
		this.medicineName = name;
		status = "Pending";
	}
	
	public void updateStatus() {
		status = "Dispensed";
	}
	
	public String getName() {
		return this.medicineName;
	}
	public String getStatus() {
		return this.status;
	}

	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Medicine Status: " + status);
	}
	
}
