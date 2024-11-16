package model;

/**
 * Represents a prescription for medicine in a hospital management system.
 * The prescription includes the medicine name and its status (e.g., pending or dispensed).
 */
 
public class Prescription {

	/**
     * Enum representing the status of a prescription.
     */

	public enum PrescriptionStatus {
        PENDING,
		DISPENSED
    }

	/**
	 * @param medicineName the name of the medicine prescribed
	 * @param status       the status of the medicine prescribed
	 */

	private String medicineName;
	private PrescriptionStatus status;
	
	 /**
     * Constructs a new Prescription object with the specified medicine name
     * 
     * @param name the name of the prescribed medicine
     */

	public Prescription(String name) {
		this.medicineName = name;
		status = PrescriptionStatus.PENDING;
	}
	
	/**
     * Updates the status of the prescription to DISPENSED.
     */

	public void updateStatus() {
		status = PrescriptionStatus.DISPENSED;
	}
	
	 /**
     * Retrieves the name of the prescribed medicine.
     * 
     * @return the name of the medicine.
     */

	public String getName() {
		return this.medicineName;
	}

	/**
     * Retrieves the current status of the prescription.
     * 
     * @return the current prescription status.
     */

	public PrescriptionStatus getStatus() {
		return this.status;
	}

	/**
     * Displays the details of the prescription, including the medicine name 
     * and the current prescription status.
     */
	
	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Medicine Status: " + status);
	}
	
}
