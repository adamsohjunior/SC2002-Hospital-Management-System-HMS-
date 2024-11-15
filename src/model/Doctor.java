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

/**
 * The Doctor Class represents the Doctor who can set his/her availabilities, accept/decline any appointment requests, record Appointment Outcome 
 * and any thing a Doctor should do and more
 */

public class Doctor extends User {
	/**
	 * This stores the Patient Medical Record for Doctor
	 */
	private ArrayList<MedicalRecord> patientMedicalRecords = new ArrayList<>();
	/**
	 * This stores Doctor's own schedule
	 */
	private Available personalSchedule;
	/**
	 * This is the "global" arrayList for all available dates
	 */
	private Available availableDates;
	/**
	 * This stores all appointment requests from patients
	 */
	private ArrayList<Appointment> appointmentRequests = new ArrayList<>();
	/**
	 * This stores all upcoming appoinment for the Doctor 
	 */
	private ArrayList<Appointment> upcomingAppointments = new ArrayList<>();
	/**
	 * This is the "global" arrayList for all appointmentOutcomeRecords for Pharmacists/Admins
	 */
	private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
	/**
	 * Scanner for input
	 */
	private Scanner scan = new Scanner(System.in);
	/**
	 * The medicine storage
	 */
	private ArrayList<Inventory> storage;
	/**
	 * Doctor personal rating
	 */
	private DoctorRating personalRating = new DoctorRating();
	
	
	/**
	 * Constructs a new Doctor with the specified details.
	 *
	 * @param id                        the unique identifier of the doctor
	 * @param name                      the name of the doctor
	 * @param age                       the age of the doctor
	 * @param gender                    the gender of the doctor
	 * @param availableDates            the schedule of all available dates
	 * @param allAppointmentOutcomeRecords a list of all appointment outcome records
	 * @param storage                   The medicine storage
	 */
	
	public Doctor(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage) {
		super(id,name,age,gender);
		personalSchedule = new Available();
		this.availableDates = availableDates;
		this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
		this.storage = storage;
	}
	/**
	 * Display Doctor's Menu
	 */
	public void displayMenu() {
		
		
		int choice=-1;
		
		System.out.println("");
		DisplayLog.display("WELCOME, " + this.getName() + "!");
		InputInt inputForMenu = new InputIntChoice(9);
		do{
			DoctorDisplayMenu.display();
			choice = inputForMenu.getIntChoice();

		      switch(choice) {
		      case 1:
		    	  viewPatientMedicalRecords();
		    	  break;
		      case 2:
		    	  updatePatientMedicalRecord(new InputIntChoice(patientMedicalRecords.size()));
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
			    System.out.println("Logged out successfully!\n");
		    	  break;
		      }
		} while (choice != 9);
		
		// scan.close();
	}
	/**
	 * Will show Doctor's own schedule(in terms of free dates)
	 */
	public void viewPersonalSchedule() {
		personalSchedule.viewAvailableAppointmentSlots();
	}
	/**
	 * This will show all of the Doctor's Patient's Medical Record
	 */
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
	/**
	 * 
	 * To select a Patient under the Doctor to update his/her Medical Record by adding new diagnosis,treatment,ConsultNotes 
	 * and prescriptions
	 * 
	 * @param inputForPatient Our InputInt interface( that is instantiated by an InputIntChoice object ) to take in INT inputs
	 * 
	 */
	public void updatePatientMedicalRecord(InputInt inputForPatient) {
		if(patientMedicalRecords.size()==0) {
			DisplayLog.display("You have no patients");
			return;
		}
		
		DisplayPrompt.display("Select patient to update their record");
		System.out.println("");
		for(int i=0;i<patientMedicalRecords.size();i++) {
			System.out.println((i+1)+") "+patientMedicalRecords.get(i).getName());
		}
		System.out.println("");
	
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
			
			InputInt inputForChoice1 = new InputIntChoice(2);
			InputInt inputForMedicineChoice = new InputIntChoice(storage.size());
			int choice1 = 0;
			while(choice1 !=2) {
				
				System.out.println("");
				System.out.println("----------------------------------------------");
				System.out.println("1) Prescribe Medication");
				System.out.println("2) Finish");
				System.out.println("----------------------------------------------");
				System.out.println("");
				

				choice1 = inputForChoice1.getIntChoice();
						
				if(choice1 == 1) {
					boolean duplicate = false;

					MedicineDisplay.display(storage);
					int medicineChoice = inputForMedicineChoice.getIntChoice();
					medicineChoice = medicineChoice-1;
					String medName = storage.get(medicineChoice).getName();

					for(int i =0;i<list.size();i++){
						if(medName.equals(list.get(i).getName())){
							duplicate = true;
							break;
						}
					}
					if(duplicate == false){
						Prescription toBePrescribed = new Prescription(medName);
						list.add(toBePrescribed);
					}
					else{
						System.out.println("Duplicate Medicine!");
					}
				}
			}
			
			AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(date, diag, treat, list, notes);
			patientMedicalRecords.get(choice).updateRecord(outcome);
	}
	/**
	 * This will set the Doctor's availability
	 */
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
		if(personalSchedule.addAvailableDates(avail)==1){
			availableDates.addAvailableDates(avail);
		}
	}
	/**
	 * Will add to Doctor's appointment requests
	 * @param appointment Appointment Request from patient
	 */
	public void incomingAppointment(Appointment appointment) {
		appointmentRequests.add(appointment);
	}
	/**
	 * 
	 * Remove appoinment when appointment is cancelled/rescheduled
	 * @param appointment Appointment to be removed
	 */
	public void removeIncommingAppointment(Appointment appointment){
		appointmentRequests.remove(appointment);
		upcomingAppointments.remove(appointment);
	}
	/**
	 * Logic to update Doctor's patient list
	 */
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
	/**
	 * This will accept or decline appointment requests
	 */
	public void acceptOrDecline() {
		if (appointmentRequests.size() == 0) {
			DisplayLog.display("There are no appointment requests.");
			return;
		}
		
		InputInt inputForAccDec = new InputIntChoice(2);

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
	/**
	 * This will show all the Doctor's upcoming appointments
	 */
	public void viewUpcomingAppointments() {
		if(upcomingAppointments.size()==0) {
			DisplayLog.display("You have no upcoming appoinments.");
			return;
		}
		
		AppointmentsDisplay.display(upcomingAppointments);
	}
	/**
	 * This will record Appointment Outcome, basically completing the appointment
	 */
	public void recordAppointmentOutcome() {
		if(this.upcomingAppointments.size() == 0) {
			DisplayLog.display("There are no appointments to complete");
			return;
		}
		
		AppointmentsDisplay.display(upcomingAppointments);
		
		InputInt inputForApp = new InputIntChoice(upcomingAppointments.size());
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
		InputInt inputForChoice1 = new InputIntChoice(2);
		InputInt inputForMedicineChoice = new InputIntChoice(storage.size());
		int choice1 = -1;
		while(choice1 !=2) {
				
			System.out.println("\n----------------------------------------------");
			System.out.println("1)Prescribe Medication");
			System.out.println("2)Finish");
			System.out.println("----------------------------------------------\n");

			choice1 = inputForChoice1.getIntChoice();
					
			if(choice1 == 1) {
				boolean duplicate = false;

				MedicineDisplay.display(storage);
				int medicineChoice = inputForMedicineChoice.getIntChoice();
				medicineChoice = medicineChoice-1;
				String medName = storage.get(medicineChoice).getName();

				for(int i =0;i<list.size();i++){
					if(medName.equals(list.get(i).getName())){
						duplicate = true;
						break;
					}
				}
				if(duplicate == false){
					Prescription toBePrescribed = new Prescription(medName);
					list.add(toBePrescribed);
				}
				else{
					System.out.println("Duplicate Medicine!");
				}
			}
		}
		
		AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(chosen.getDate(), diag, treat, list, notes);
		chosen.updateAppointment(outcome);
		
		/* update the global list so that pharmacists can see and perform their task */
		allAppointmentOutcomeRecords.add(outcome);
		chosen.getPatient().updatePatientOutcome(outcome);
		chosen.getPatient().updateDoctorsVisited(this);
		chosen.getPatient().getMedicalRecord().updateRecord(outcome);
	}

	public DoctorRating getRating(){
		return personalRating;
	}

}
