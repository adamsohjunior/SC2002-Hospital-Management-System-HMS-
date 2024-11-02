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
	
	public void printRecord() { 
		System.out.println(userId); 
		System.out.println(name); 
		System.out.println(email); 
		System.out.println(dateOfBirth); 
		System.out.println(gender); 
		System.out.println(bloodType); 

		System.out.println("Past diagnoses, treatments and prescriptions: "); 
		for (int i = 0; i< diagnosesTreatmentPrescription.size(); i++) { 
			System.out.print(i+1+")"); 
			diagnosesTreatmentPrescription.get(i).printInfo(); 
			System.out.println(""); 
		} 
		System.out.println();
	}
	  
	public void updateRecord(String email) {
		this.email = email;
	}
	
	public void updateRecord(AppointmentOutcomeRecord outcome) {
		diagnosesTreatmentPrescription.add(outcome);
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
}
