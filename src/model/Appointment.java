package model;

/**
 * The Appointment class represents an appointment between a doctor and a patient,
 * with information such as the appointment date, time, status, and outcome record.
 */
public class Appointment {
	private Patient patient;
	private Doctor doctor;
	private String date;
	private String time;
	private String status;
	private AppointmentOutcomeRecord outcome = null;

	/**
	 * Constructs an Appointment object with the given doctor, date, time, and patient.
	 * The appointment status is set to "Pending" by default.
	 *
	 * @param doctor the doctor associated with the appointment
	 * @param date the date of the appointment
	 * @param time the time of the appointment
	 * @param patient the patient associated with the appointment
	 */
	public Appointment(Doctor doctor, String date, String time, Patient patient) {
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.status = "Pending";
	}

	/**
	 * Updates the status of the appointment to "Completed" and sets the outcome record.
	 *
	 * @param newOutcome the new outcome record for the appointment
	 */
	public void updateAppointment(AppointmentOutcomeRecord newOutcome) {
		status = "Completed";
		this.outcome = newOutcome;
	}

	/**
	 * Prints the appointment details for an administrator, including the patient and doctor IDs,
	 * appointment date and time, status, and outcome record (if available).
	 */
	public void printInfoForAdmin() {
		System.out.println("Patient: " + this.patient.getUserId());
		System.out.println("Doctor: " + this.doctor.getUserId());
		System.out.println("Date: " + this.date);
		System.out.println("Time: " + this.time);
		System.out.println("Status: " + this.status);
		if(outcome != null) {
			System.out.println("Application Outcome Record:");
			outcome.printInfo();
			System.out.println("");
		}
	}

	/**
	 * Gets the appointment outcome record.
	 *
	 * @return the outcome record of the appointment, or null if not available
	 */
	public AppointmentOutcomeRecord getAppointmentOutcome() {
		return this.outcome;
	}

	/**
	 * Gets the date of the appointment.
	 *
	 * @return the date of the appointment
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the time of the appointment.
	 *
	 * @return the time of the appointment
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Gets the doctor associated with the appointment.
	 *
	 * @return the doctor of the appointment
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * Gets the patient associated with the appointment.
	 *
	 * @return the patient of the appointment
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Gets the status of the appointment.
	 *
	 * @return the status of the appointment
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the appointment.
	 *
	 * @param status the new status of the appointment
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
