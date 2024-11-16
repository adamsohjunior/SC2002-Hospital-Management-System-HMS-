package view;
import model.MedicalRecord;

/**
 * The MedicalRecordDisplay class is responsible for displaying the details of a MedicalRecord.
 * It provides a method to display the medical record's user information and a list of diagnoses, treatments, 
 * and prescriptions, if available. This class formats and prints the medical record details in a readable format.
 * 
 * <p>Example usage:</p>
 * <pre>
 * MedicalRecord mR = new MedicalRecord(...);  // Create a MedicalRecord instance
 * MedicalRecordDisplay.display(mR);  // Display the details of the medical record
 * </pre>
 * 
 * @see MedicalRecord
 */

public class MedicalRecordDisplay implements DisplayInfo{

	 /**
     * Displays the medical record details, including user ID, name, email, date of birth, gender, blood type, and any diagnoses,
     * treatments, and prescriptions associated with the record.
     *
     * @param mR the MedicalRecord object whose details are to be displayed.
     */

	static public void display(MedicalRecord mR) {
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "	  " + mR.getName() + " Medical Record			   ");
		System.out.println(border);
		System.out.println(mR.getUserId());
		System.out.println(mR.getName());
		System.out.println(mR.getEmail());
		System.out.println(mR.getDateOfBirth());
		System.out.println(mR.getGender());
		System.out.println(mR.getBloodType());
		System.out.println("");

		// If there are diagnoses, treatments, and prescriptions, display them.
		if(mR.getDiagnosesTreatmentPrescription().size() != 0){
			System.out.println("** Past Diagnoses, Treatments and Prescriptions ** ");
			AppointmentOutcomeRecordDisplay.display(mR.getDiagnosesTreatmentPrescription());
		}

		System.out.println(border);
		System.out.println("");
	}
}
