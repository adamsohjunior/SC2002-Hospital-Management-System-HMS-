package model;
import java.util.ArrayList;

public class MedicalRecord {
	
	private String userId;
	private String email;
	private String gender;
	private String name;
	private String bloodType;
	private String dateOfBirth;
	private ArrayList<AppointmentOutcomeRecord> diagnosesTreatmentPrescription = new ArrayList<>();
	
	
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

    public ArrayList<AppointmentOutcomeRecord> getDiagnosesTreatmentPrescription() {
        return diagnosesTreatmentPrescription;
    }
}