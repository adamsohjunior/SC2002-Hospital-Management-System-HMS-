package view;

import java.util.ArrayList;

import model.AppointmentOutcomeRecord;

public class AppointmentOutcomeRecordDisplay implements DisplayInfo {


    static public void display(ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords) {
		// System.out.println("Appointment Outcome Record:");     // DISCLAIMER: everyone put this line into your own main file before calling this method
		System.out.println("");
		for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            System.out.println("Date: "+record.getDate());
            System.out.println("Diagnoses: "+record.getDiagnoses());
            System.out.println("Treatment: "+record.getTreatment());
            System.out.println("Consultation Notes: "+record.getConsultationNotes());
            System.out.print("Prescriptions: ");
            for(int i = 0; i < record.getPrescriptionList().size() ; i++) {
                System.out.print(record.getPrescriptionList().get(i).getName() + "(" + record.getPrescriptionList().get(i).getStatus() + ")" + " ");
            }
            System.out.println("");

        }
		System.out.println("");
    }

}
