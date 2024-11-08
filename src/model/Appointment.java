package model;
public class Appointment {
	private Patient patient;
	private Doctor doctor;
	private String date;
	private String time;
	private String status;
	private AppointmentOutcomeRecord outcome = null;
	
	public Appointment(Doctor doctor, String date, String time, Patient patient) {
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.status = "Pending";
	}
	
	public void updateAppointment(AppointmentOutcomeRecord newOutcome) {
		status = "Completed";
		this.outcome = newOutcome;
	}
	
	public void printInfo() {
		System.out.println("Patient: "+this.patient.getName());
		System.out.println("Doctor: "+this.doctor.getName());
		System.out.println("Date: "+this.date);
		System.out.println("Time: "+this.time);
		System.out.println("Status: "+this.status);
	}
	
	public void printInfoForAdmin() {
		System.out.println("Patient: "+this.patient.getUserId());
		System.out.println("Doctor: "+this.doctor.getUserId());
		System.out.println("Date: "+this.date);
		System.out.println("Time: "+this.time);
		System.out.println("Status: "+this.status);
		if(outcome != null) {
			System.out.println("Application Outcome Record:");
			outcome.printInfo();
			System.out.println("");
		}
	}
	
	public AppointmentOutcomeRecord getAppointmentOutcome() {
		return this.outcome;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
