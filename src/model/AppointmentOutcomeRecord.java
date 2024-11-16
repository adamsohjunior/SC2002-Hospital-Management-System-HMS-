package model;

import java.util.ArrayList;

/**
 * The AppointmentOutcomeRecord class stores the details of an appointment's outcome,
 * including diagnoses, treatment, consultation notes, and a list of prescriptions.
 */
public class AppointmentOutcomeRecord {
	private String date;
	private String diagnoses;
	private String treatment;
	private String consultationNotes;
	private ArrayList<Prescription> prescriptionList = new ArrayList<>();

	/**
	 * Constructs an AppointmentOutcomeRecord object with the given date, diagnoses,
	 * treatment, prescription list, and consultation notes.
	 *
	 * @param date the date of the appointment outcome
	 * @param diagnose the diagnoses made during the appointment
	 * @param treatment the treatment given during the appointment
	 * @param prescriptionList the list of prescriptions given during the appointment
	 * @param consultationNotes the notes made during the consultation
	 */
	public AppointmentOutcomeRecord(String date, String diagnose, String treatment, ArrayList<Prescription> prescriptionList, String consultationNotes) {
		this.date = date;
		this.diagnoses = diagnose;
		this.treatment = treatment;
		this.consultationNotes = consultationNotes;
		this.prescriptionList = prescriptionList;
	}

	/**
	 * Gets the date of the appointment outcome.
	 *
	 * @return the date of the appointment outcome
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Gets the diagnoses made during the appointment.
	 *
	 * @return the diagnoses made during the appointment
	 */
	public String getDiagnoses() {
		return this.diagnoses;
	}

	/**
	 * Gets the treatment given during the appointment.
	 *
	 * @return the treatment given during the appointment
	 */
	public String getTreatment() {
		return this.treatment;
	}

	/**
	 * Gets the list of prescriptions given during the appointment.
	 *
	 * @return the list of prescriptions given during the appointment
	 */
	public ArrayList<Prescription> getPrescriptionList() {
		return this.prescriptionList;
	}

	/**
	 * Gets the consultation notes from the appointment.
	 *
	 * @return the consultation notes from the appointment
	 */
	public String getConsultationNotes() {
		return this.consultationNotes;
	}

	/**
	 * Sets the consultation notes for the appointment.
	 *
	 * @param consultationNotes the new consultation notes for the appointment
	 */
	public void setConsultationNotes(String consultationNotes) {
		this.consultationNotes = consultationNotes;
	}

	/**
	 * Sets the diagnoses for the appointment.
	 *
	 * @param diagnose the new diagnoses for the appointment
	 */
	public void setDiagnoses(String diagnose) {
		this.diagnoses = diagnose;
	}

	/**
	 * Sets the treatment for the appointment.
	 *
	 * @param treatment the new treatment for the appointment
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * Sets the prescription list for the appointment.
	 *
	 * @param prescriptionList the new list of prescriptions for the appointment
	 */
	public void setPrescriptionList(ArrayList<Prescription> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}

	/**
	 * Prints all the information related to the appointment outcome,
	 * including the date, diagnoses, treatment, consultation notes,
	 * and a list of prescriptions with their status.
	 */
	public void printInfo() {
		System.out.println("Date: " + this.date);
		System.out.println("Diagnoses: " + this.diagnoses);
		System.out.println("Treatment: " + this.treatment);
		System.out.println("Consultation Notes: " + this.consultationNotes);
		System.out.print("Prescriptions: ");
		for (int i = 0; i < prescriptionList.size(); i++) {
			System.out.print(this.prescriptionList.get(i).getName() + "(" + this.prescriptionList.get(i).getStatus() + ")" + " ");
		}
	}
}
