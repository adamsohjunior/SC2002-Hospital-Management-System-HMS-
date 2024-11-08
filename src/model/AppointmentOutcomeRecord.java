package model;
import java.util.ArrayList;

public class AppointmentOutcomeRecord {
	private String date;
	private String diagnoses;
	private String treatment;
	private String consultationNotes;
	private ArrayList<Prescription> prescriptionList = new ArrayList<>();
	
	public AppointmentOutcomeRecord(String date, String diagnose, String treatment, ArrayList<Prescription> prescriptionList, String consultationNotes) {
		this.date = date;
		this.diagnoses = diagnose;
		this.treatment = treatment;
		this.consultationNotes = consultationNotes;
		this.prescriptionList = prescriptionList;
	}
	
	public String getDate() {
		return this.date;
	}
	public String getDiagnoses() {
		return this.diagnoses;
	}
	public String getTreatment() {
		return this.treatment;
	}
	public ArrayList<Prescription> getPrescriptionList() {
		return this.prescriptionList;
	}
	public String getConsultationNotes() {
		return this.consultationNotes;
	}
	
	public void setConsultationNotes(String consultationNotes) {
		this.consultationNotes = consultationNotes;
	}
	public void setDiagnoses(String diagnose) {
		this.diagnoses = diagnose;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public void setPrescriptionList(ArrayList<Prescription> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}
	
	public void printInfo() {
		System.out.println("Date: "+this.date);
		System.out.println("Diagnoses: "+this.diagnoses);
		System.out.println("Treatment: "+this.treatment);
		System.out.println("Consultation Notes: "+this.consultationNotes);
		System.out.print("Prescriptions: ");
		for(int i = 0; i < prescriptionList.size() ; i++) {
			System.out.print(this.prescriptionList.get(i).getName() + "(" + this.prescriptionList.get(i).getStatus() + ")" + " ");
		}
	}
}
