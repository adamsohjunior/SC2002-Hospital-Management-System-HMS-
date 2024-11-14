package view;
import model.MedicalRecord;

public class MedicalRecordDisplay implements DisplayInfo{
	static public void display(MedicalRecord mR) {
		System.out.println("");
		System.out.println(mR.getName()+" Medical Record");
		System.out.println("==============================================");
		System.out.println(mR.getUserId());
		System.out.println(mR.getName());
		System.out.println(mR.getEmail());
		System.out.println(mR.getDateOfBirth());
		System.out.println(mR.getGender());
		System.out.println(mR.getBloodType());
		System.out.println("");
		System.out.println("Past diagnoses, treatments and prescriptions: ");

		AppointmentOutcomeRecordDisplay.display(mR.getDiagnosesTreatmentPrescription());

		System.out.println("");
	}
}
