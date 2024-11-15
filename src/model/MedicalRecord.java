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
     * Constructs a new Medical Record with the specified details.
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
	
	public void updateRecord(String email) {
		this.email = email;
	}
	
	public void updateRecord(AppointmentOutcomeRecord outcome) {
		diagnosesTreatmentPrescription.add(outcome);
	}

    // Getters for all private attributes
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodType() {
        return bloodType;
    }
    

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return email;
    }

    public ArrayList<AppointmentOutcomeRecord> getDiagnosesTreatmentPrescription() {
        return diagnosesTreatmentPrescription;
    }
}