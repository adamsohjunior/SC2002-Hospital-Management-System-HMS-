package view;
import model.MedicalRecord;

public class MedicalRecordDisplay implements DisplayInfo{
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

		if(mR.getDiagnosesTreatmentPrescription().size() != 0){
			System.out.println("** Past Diagnoses, Treatments and Prescriptions ** ");
			AppointmentOutcomeRecordDisplay.display(mR.getDiagnosesTreatmentPrescription());
		}

		System.out.println(border);
		System.out.println("");
	}
}
