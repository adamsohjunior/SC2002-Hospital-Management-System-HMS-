package model;

/**
 * The Availability class represents the availability of a doctor for an appointment,
 * including the doctor's information, date, time, and current status of availability.
 */
public class Availability {
	private Doctor doctor;
	private String date;
	private String time;
	private String status;

	/**
	 * Constructs an Availability object with the given doctor, date, and time.
	 * The status is initially set to "Available".
	 *
	 * @param doc the doctor associated with this availability
	 * @param date the date of the doctor's availability
	 * @param time the time of the doctor's availability
	 */
	public Availability(Doctor doc, String date, String time) {
		doctor = doc;
		this.date = date;
		this.time = time;
		status = "Available";
	}

	/**
	 * Gets the doctor associated with this availability.
	 *
	 * @return the doctor associated with this availability
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * Gets the date of the doctor's availability.
	 *
	 * @return the date of the doctor's availability
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the time of the doctor's availability.
	 *
	 * @return the time of the doctor's availability
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Gets the current status of the doctor's availability.
	 *
	 * @return the current status of the doctor's availability
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the doctor's availability to a new status.
	 *
	 * @param newStatus the new status to be set
	 */
	public void setStatus(String newStatus) {
		this.status = newStatus;
	}
}
