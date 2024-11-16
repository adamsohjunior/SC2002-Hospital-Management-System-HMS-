package model;
import java.util.ArrayList;


/**
 * This is a Medical Record class that will contain all the medical information of a Patient
 * This will also contain the past diagnosis,treatment,etc... of said patient
 */
public class MedicalRecord {
	
    /**
     * Patient Identification 
     */
	private String userId;
    /**
     * Patient Email
     */
	private String email;
    /**
     * Patient Gender
     */
	private String gender;
    /**
     * Patient Name
     */
	private String name;
    /**
     * Patient Blood Type
     */
	private String bloodType;
    /**
     * Patient Date Of Birth
     */
	private String dateOfBirth;
    /**
     * Patient past diagnosis, treatments and prescriptions
     */
	private ArrayList<AppointmentOutcomeRecord> diagnosesTreatmentPrescription = new ArrayList<>();
	
	/**
     * Constructs a new Medical Record object with the specified details.
     * 
     * @param id Patient Identification 
     * @param name Patient Name
     * @param email Patient Email
     * @param bloodType Patient Blood Type
     * @param dateOfBirth Patient Date Of Birth
     * @param gender Patient Gender
     */
	public MedicalRecord(String id, String name, String email, String bloodType, String dateOfBirth, String gender) {
		userId = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.bloodType = bloodType;
		this.dateOfBirth = dateOfBirth;
	}
	/**
     * Update Patient Email
     * @param email
     */
	public void updateRecord(String email) {
		this.email = email;
	}
	/**
     * Add diagnosis,treatment and prescription
     * @param outcome An appointmentOutcomeRecord to update Patient Medical History
     */
	public void updateRecord(AppointmentOutcomeRecord outcome) {
		diagnosesTreatmentPrescription.add(outcome);
	}

    /**
     * Get Patient Id
     * @return Patient Id
     */
    public String getUserId() {
        return userId;
    }
    /**
     * Get Patient Name
     * @return Patient Name
     */
    public String getName() {
        return name;
    }
    /**
     * Get Patient Email
     * @return Patient Email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Get Patient Blood Type
     * @return Patient Blood Type
     */
    public String getBloodType() {
        return bloodType;
    }
    
    /**
     * Get Patient Date Of Birth
     * @return Patient Date Of Birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Get Patient Gender
     * @return Patient Gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get past diagnosis,treatments and prescriptions
     * @return diagnosis,treatments and prescriptions
     */
    public ArrayList<AppointmentOutcomeRecord> getDiagnosesTreatmentPrescription() {
        return diagnosesTreatmentPrescription;
    }
}