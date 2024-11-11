package model;
public class Prescription {

	public enum PrescriptionStatus {
        PENDING,
		DISPENSED
    }
	private String medicineName;
	private PrescriptionStatus status;
	
	public Prescription(String name) {
		this.medicineName = name;
		status = PrescriptionStatus.PENDING;
	}
	
	public void updateStatus() {
		status = PrescriptionStatus.DISPENSED;
	}
	
	public String getName() {
		return this.medicineName;
	}
	public PrescriptionStatus getStatus() {
		return this.status;
	}

	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Medicine Status: " + status);
	}
	
}
