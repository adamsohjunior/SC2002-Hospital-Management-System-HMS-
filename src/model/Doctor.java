package model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import view.AppointmentsDisplay;
import view.DayDisplay;
import view.DisplayLog;
import view.DisplayPrompt;
import view.DoctorDisplayMenu;
import view.InputDayChoice;
import view.InputInt;
import view.InputIntChoice;
import view.InputMonthChoice;
import view.InputTimeChoice;
import view.MedicalRecordDisplay;
import view.MedicineDisplay;
import view.MonthDisplay;
import view.TimeDisplay;

public class Doctor extends User {

	private ArrayList<MedicalRecord> patientMedicalRecords = new ArrayList<>();
	private Available personalSchedule;
	private Available availableDates;
	private ArrayList<Appointment> appointmentRequests = new ArrayList<>();
	private ArrayList<Appointment> upcomingAppointments = new ArrayList<>();
	private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Inventory> storage;
	
	/* availableDates is same with patient, here is where we are able to update it for patient use
	 * 
	 * allAppointmentOutcomeRecords is the global list for all appointmentoutcomerecords. Since the doctor is the one making this class (see method below) when they want to 'complete' the appointment
	 * and write up on diagnoses,treatment,pres...etc, they will make a AppointmentOutcomeRecord object. This object is stored in both the current appointment object and this global list.
	 * This global list is then ACCESSED by PHARMACISTS so they can do their job of prescribing the medicine, update status, etc.
	 */
	
	
	public Doctor(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage) {
		super(id,name,age,gender);
		personalSchedule = new Available();
		this.availableDates = availableDates;
		this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
		this.storage = storage;
	}
	
	public void displayMenu() {
		/* To be done */
		
		int choice=-1;
		
		System.out.println("");
		DisplayLog.display("WELCOME, " + this.getName() + "!");
		InputIntChoice inputForMenu = new InputIntChoice(9);
		do{
			DoctorDisplayMenu.display();
			choice = inputForMenu.getIntChoice();

		      switch(choice) {
		      case 1:
		    	  viewPatientMedicalRecords();
		    	  break;
		      case 2:
		    	  updatePatientMedicalRecord();
		    	  break;
		      case 3:
		    	  viewPersonalSchedule();
		    	  break;
		      case 4:
		    	  setAvailability();
		    	  break;
		      case 5:
		    	  acceptOrDecline();
		    	  break;
		      case 6:
		    	  viewUpcomingAppointments();
		    	  break;
		      case 7:
		    	  recordAppointmentOutcome();
		    	  break;
			  case 8:
				  showInbox();
				  break;
		      case 9:
		    	  break;
		      }
		} while (choice != 9);
		
		// scan.close();
	}
	
	public void viewPersonalSchedule() {
		personalSchedule.viewAvailableAppointmentSlots();
	}
	
	public void viewPatientMedicalRecords() {
		if (patientMedicalRecords.size() == 0) {
			DisplayLog.display("No patients");
			return;
		}

		for(int j = 0;j<patientMedicalRecords.size();j++) {
			MedicalRecordDisplay.display(patientMedicalRecords.get(j));
			DisplayLog.display("");
		}
	}
	
	public void updatePatientMedicalRecord() {
		if(patientMedicalRecords.size()==0) {
			DisplayLog.display("You have no patients");
			return;
		}
		InputIntChoice inputForPatient = new InputIntChoice(patientMedicalRecords.size());
		DisplayPrompt.display("Select patient to update their record");
		for(int i=0;i<patientMedicalRecords.size();i++) {
			System.out.println((i+1)+")"+patientMedicalRecords.get(i).getName());
		}
		
	
		int choice =-1;
	      choice = inputForPatient.getIntChoice();
			choice = choice-1;

			MonthDisplay.display();
			InputMonthChoice inputForMonth = new InputMonthChoice();
			String month = inputForMonth.getMonth();

			DayDisplay.display();
			InputDayChoice inputForDay = new InputDayChoice();
			int day = inputForDay.getDay(month);

			String date = day + " " + month;

			DisplayPrompt.display("\nPlease enter your diagnoses: ");
			String diag = scan.nextLine();
			DisplayPrompt.display("\nPlease enter your treatment: ");
			String treat = scan.nextLine();
			DisplayPrompt.display("\nPlease enter your consultation notes: ");
			String notes = scan.nextLine();
			DisplayLog.display("");
			
			/* here can change to list of medications instead of the doctor manually enterint the name*/
			ArrayList<Prescription> list = new ArrayList<>();
			
			InputIntChoice inputForChoice1 = new InputIntChoice(2);
			InputIntChoice inputForMedicineChoice = new InputIntChoice(storage.size());
			int choice1 = 0;
			while(choice1 !=2) {
				
				System.out.println("");
				System.out.println("==============================================");
				System.out.println("1)Prescribe Medication");
				System.out.println("2)Finish");
				System.out.println("==============================================");
				System.out.println("");
				

				choice1 = inputForChoice1.getIntChoice();
						
				if(choice1 == 1) {
					
					MedicineDisplay.display(storage);
					int medicineChoice = inputForMedicineChoice.getIntChoice();
					medicineChoice = medicineChoice-1;
					String medName = storage.get(medicineChoice).getName();

					Prescription toBePrescribed = new Prescription(medName);
					list.add(toBePrescribed);
				}
			}
			
			AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(date, diag, treat, list, notes);
			patientMedicalRecords.get(choice).updateRecord(outcome);
	}
	
	public void setAvailability() {
		MonthDisplay.display();
		InputMonthChoice inputForMonth = new InputMonthChoice();
		String month = inputForMonth.getMonth();

		DayDisplay.display();
		InputDayChoice inputForDay = new InputDayChoice();
		int day = inputForDay.getDay(month);

		String date = day + " " + month;
		
		TimeDisplay.display();
		InputTimeChoice inputForTime = new InputTimeChoice();
		String time = inputForTime.getTime();
		
		Availability avail = new Availability(this,date,time);
		/* Both arraylist contains the same ref to Availability object */
		personalSchedule.addAvailableDates(avail);
		availableDates.addAvailableDates(avail);
	}
	
	public void incomingAppointment(Appointment appointment) {
		appointmentRequests.add(appointment);
	}
	public void removeIncommingAppointment(Appointment appointment){
		appointmentRequests.remove(appointment);
		upcomingAppointments.remove(appointment);
	}
	
	private void updatePatientList() {
		ArrayList<MedicalRecord> temp = new ArrayList<>();
		for(int i =0;i<upcomingAppointments.size();i++) {
			String checkId = upcomingAppointments.get(i).getPatient().getUserId();
			int in = 0;
			for(int j = 0;j<temp.size();j++) {
				if(checkId.equals(temp.get(j).getUserId())) {
					in = 1;
					break;
				}
			}
			if (in == 0) {
				temp.add(upcomingAppointments.get(i).getPatient().getMedicalRecord());
			}
		}
		
		this.patientMedicalRecords = temp;
	}
	
	public void acceptOrDecline() {
		if (appointmentRequests.size() == 0) {
			DisplayLog.display("There are no appointment requests.");
			return;
		}
		
		DisplayLog.display("Appointment requests: ");
		InputIntChoice inputForAccDec = new InputIntChoice(2);

		

		for (int i = 0;i<appointmentRequests.size();i++) {
			Appointment temp = appointmentRequests.get(i);
			ArrayList<Appointment> tempList = new ArrayList<Appointment>();
			tempList.add(temp);
			AppointmentsDisplay.display(tempList);
			
			int choice = 0;
	        DisplayPrompt.display("1 to Accept || 2 to Decline");
			System.out.println("");	
	        choice = inputForAccDec.getIntChoice();
			
			if(choice == 1) {
				temp.setStatus("Accepted");
				upcomingAppointments.add(temp);
				
				updatePatientList();
				sendMessage(temp.getPatient(), "Dr "+temp.getDoctor().getName()+" has ACCEPTED your appointment on "+temp.getDate()+" "+temp.getTime());
			}
			else {
				temp.setStatus("Rejected");
				
				sendMessage(temp.getPatient(), "Dr "+temp.getDoctor().getName()+" has REJECTED your appointment on "+temp.getDate()+" "+temp.getTime());
				Doctor doc = temp.getDoctor();
				String dat = temp.getDate();
				String tim = temp.getTime();
				
				/* this should update the availability object for both personal and global since both contain the same ref to the object*/
				this.availableDates.updateAvailableDates(doc, dat, tim);
			}
		}
		appointmentRequests.clear();
	}
	
	public void viewUpcomingAppointments() {
		if(upcomingAppointments.size()==0) {
			DisplayLog.display("You have no upcoming appoinments.");
			return;
		}
		
		AppointmentsDisplay.display(upcomingAppointments);
	}
	
	public void recordAppointmentOutcome() {
		if(this.upcomingAppointments.size() == 0) {
			DisplayLog.display("There are no appointments to complete");
			return;
		}
		
		AppointmentsDisplay.display(upcomingAppointments);
		
		InputIntChoice inputForApp = new InputIntChoice(upcomingAppointments.size());
		int choice = 0;
		
		DisplayLog.display("Please select an appointment to complete: ");
		choice = inputForApp.getIntChoice()-1;

		Appointment chosen = upcomingAppointments.get(choice);
		upcomingAppointments.remove(chosen);
		updatePatientList();

		DisplayLog.display("\nPlease enter your diagnoses: ");
		String diag = scan.nextLine();
		DisplayLog.display("\nPlease enter your treatment: ");
		String treat = scan.nextLine();
		DisplayLog.display("\nPlease enter your consultation notes: ");
		String notes = scan.nextLine();
		DisplayPrompt.display("");
		

		/* here can change to list of medications instead of the doctor manually enterint the name*/
		ArrayList<Prescription> list = new ArrayList<>();
		InputIntChoice inputForChoice1 = new InputIntChoice(2);
		InputIntChoice inputForMedicineChoice = new InputIntChoice(storage.size());
		int choice1 = -1;
		while(choice1 !=2) {
				
			System.out.println("\n==============================================");
			System.out.println("1)Prescribe Medication");
			System.out.println("2)Finish");
			System.out.println("==============================================\n");

			choice1 = inputForChoice1.getIntChoice();
					
			if(choice1 == 1) {
				
				MedicineDisplay.display(storage);
				int medicineChoice = inputForMedicineChoice.getIntChoice();
				medicineChoice = medicineChoice-1;
				String medName = storage.get(medicineChoice).getName();

				Prescription toBePrescribed = new Prescription(medName);
				list.add(toBePrescribed);
			}
		}
		
		AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(chosen.getDate(), diag, treat, list, notes);
		chosen.updateAppointment(outcome);
		
		/* update the global list so that pharmacists can see and perform their task */
		allAppointmentOutcomeRecords.add(outcome);
		chosen.getPatient().updatePatientOutcome(outcome);
		chosen.getPatient().getMedicalRecord().updateRecord(outcome);
	}

}
