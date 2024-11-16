package model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import view.AppointmentOutcomeRecordDisplay;
import view.AppointmentsDisplay;
import view.EmailUpdateDisplay;
import view.InputEmail;
import view.InputInt;
import view.InputIntChoice;
import view.MedicalRecordDisplay;
import view.PatientDisplayMenu;
import view.DisplayLog;
import view.DisplayPrompt;
import view.DoctorRatingDisplay;
import view.DoctorRateDisplay;

/**
 * The Patient Class represents the Patient that has his own Medical Record, schedule appointment with a Doctor, reschedule/cancel and
 * able to rate Doctors they have visited and more...
 */

public class Patient extends User{
	/**
	 * Patient own Medical Record
	 */
	private MedicalRecord medicalRecord;
	/**
	 * Patient scheduled appointment
	 */
	private ArrayList<Appointment> scheduledAppointments = new ArrayList<>();
	/**
	 * The 'global' array for all available dates
	 */
	private Available availableDates;
	/**
	 * Patient own appointment outcome records
	 */
	private ArrayList<AppointmentOutcomeRecord> appointmentOutcomeRecords = new ArrayList<>();
	/**
	 * The 'global' array for all appointments
	 */
	private ArrayList<Appointment> allAppointments;
	/**
	 * Doctors visited to be rated
	 */
	private Set<Doctor> doctorsVisited = new HashSet<>();

	
	
	/**
	 * 
	 * Constructs a new Patient object with the specified details.
	 * 
	 * @param id Patient Id
	 * @param name Patient Name
	 * @param age Patient Age
	 * @param email Patient Email
	 * @param bloodType Patient Blood Type
	 * @param dateOfBirth Patient Date Of Birth
	 * @param availableDates All available dates
	 * @param gender Patient Gender
	 * @param allAppointments All Appointments
	 */
	// removed contactNumber
	public Patient(String id, String name, int age, String email, String bloodType, String dateOfBirth, Available availableDates, String gender, ArrayList<Appointment> allAppointments) {
		
		super(id,name,age,gender);

		medicalRecord = new MedicalRecord(id,name,email,bloodType,dateOfBirth,gender);
		this.allAppointments = allAppointments;
		this.availableDates = availableDates;
	}
	/**
	 * Display Patient Menu
	 */
	public void displayMenu() {

		
		int choice=-1;
		InputInt inputForMenu = new InputIntChoice(11);
		System.out.println("");
		DisplayLog.display("WELCOME, " + this.getName() + "!");
		do{
			PatientDisplayMenu.display();
			choice = inputForMenu.getIntChoice();

		      switch(choice) {
		      case 1:
		    	  viewMedicalRecord();
		    	  break;
		      case 2:
		    	//   boolean proof = false;
		    	//   int contact = -1;
		    	  
		    	  
				  EmailUpdateDisplay.display();

		    	  InputEmail inputForEmail = new InputEmail();
				  String email = inputForEmail.getStringInput();
		    	  
		    	//   while(!proof) {
			    // 	  try {
				//     	  System.out.print("Please input new contact number: ");
				//     	  contact = scan.nextInt();
				//     	  proof = true;
			    // 	  } catch (InputMismatchException e) {
			    //             System.out.println("Invalid input! Please enter an appropriate choice.");
			    //             scan.next(); 
			    //         }
		    	//   }
				// 	/* clear the enter key */
				// 	scan.nextLine(); 
					
		    	  updatePersonalInfo(email);
		    	  break;
		      case 3:
		    	  availableDates.viewAvailableAppointmentSlots();
		    	  break;
		      case 4:
		    	  scheduleAppointment();
		    	  break;
		      case 5:
		    	  rescheduleAppointment();
		    	  break;
		      case 6:
		    	  cancelAppointment();
		    	  break;
		      case 7:
		    	  viewScheduledAppointments();
		    	  break;
		      case 8:
		    	  viewAppointmentOutcomeRecords();
		    	  break;
			  case 9:
				  showInbox();
				  break;
		      case 10:
				  rateDoctor(new InputIntChoice(5));
		    	  break;
			  case 11:
				  System.out.println("Logged out successfully!\n");
				  break;
		      }
		} while (choice != 11);
		
		// scan.close();
	}
	
	/**
	 * Get Patient Medical Record
	 * @return Medical Record
	 */
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	
	/**
	 * Get Patient scheduled appointments
	 * @return Patient scheduled appointments
	 */
	public ArrayList<Appointment> getScheduledAppointments(){
		return scheduledAppointments;
	}
	/**
	 * Update Patient's appoint outcome record
	 * @param appoinment The appointment to that is completed
	 */
	public void updateAppointmentOutcomeRecords(Appointment appoinment) {
		scheduledAppointments.remove(appoinment);
		AppointmentOutcomeRecord outcome = appoinment.getAppointmentOutcome();
		appointmentOutcomeRecords.add(outcome);
	}
	/**
	 * Display Patient's Medical Record
	 */
	public void viewMedicalRecord() {
		MedicalRecordDisplay.display(medicalRecord);
	}
	/**
	 * Update Patient's Email
	 * @param newEmailString Patient New Email
	 */
	public void updatePersonalInfo(String newEmailString) {
		medicalRecord.updateRecord(newEmailString);
	}
	
	/**
	 * Display the Patient's appointment outcome record
	 */
	public void viewAppointmentOutcomeRecords() {
		if(this.appointmentOutcomeRecords.size() == 0) {
			DisplayLog.display("There are no records.");
			return;
		}
		AppointmentOutcomeRecordDisplay.display(appointmentOutcomeRecords);
	}
	
	/**
	 * Display the Patient's scheduled appointments
	 */
	public void viewScheduledAppointments() {
		if(this.scheduledAppointments.size()==0) {
			DisplayLog.display("There are no appointments.");
			return;
		}

		System.out.println("");
		AppointmentsDisplay.display(scheduledAppointments);
		System.out.println("");

	}
	
	/**
	 * Schedule an appointment with a Doctor
	 * Select a doctor, date and time and send appointment requests
	 */
	public void scheduleAppointment() {
		Appointment appointment = availableDates.selectAvailableSlot(scheduledAppointments,this);
		if (appointment == null){ 
			return; 
		}
		scheduledAppointments.add(appointment);
		/* this is a reference to the global appointment list that all classes can access as it is in the main system */
		allAppointments.add(appointment);
	
		sendMessage(appointment.getDoctor(), appointment.getPatient().getName()+" has SCHEDULED an appointment on "+appointment.getDate()+" "+appointment.getTime());
	}
	
	/**
	 * Reschedule an appointment
	 */
	public void rescheduleAppointment() {

		System.out.println("Rescheduling Appointment: ");
		System.out.println("Please Select An Appointment To Cancel and then Reschedule ");
		System.out.println("");
		if (cancelAppointment()) {
			scheduleAppointment();
		}
		else {
			DisplayLog.display("There are no appointments to reschedule");
		}

	}
	/**
	 * Select an appointment to cancel
	 * @return a boolean value to indicate whether cancelling is succesfull or not
	 */
	public boolean cancelAppointment() {
		if(this.scheduledAppointments.size() == 0) {
			DisplayLog.display("There are no appointments to cancel");
			return false;
		}
		
		
		AppointmentsDisplay.display(scheduledAppointments);

		int choice = 0;
		DisplayPrompt.display("Please select an appointment to cancel -> ");
		InputInt inputForAppointment = new InputIntChoice(scheduledAppointments.size());
		choice  = inputForAppointment.getIntChoice();
     
		choice = choice-1;
		Appointment appoinmentToBeRemoved = this.scheduledAppointments.get(choice);
		this.scheduledAppointments.remove(appoinmentToBeRemoved);
		this.allAppointments.remove(appoinmentToBeRemoved);
		

		Doctor doc = appoinmentToBeRemoved.getDoctor();
		String dat = appoinmentToBeRemoved.getDate();
		String tim = appoinmentToBeRemoved.getTime();
		
		doc.removeIncommingAppointment(appoinmentToBeRemoved);
		sendMessage(appoinmentToBeRemoved.getDoctor(), appoinmentToBeRemoved.getPatient().getName()+" has CANCELLED an appointment on "+appoinmentToBeRemoved.getDate()+" "+appoinmentToBeRemoved.getTime());
		this.availableDates.updateAvailableDates(doc, dat, tim);
		return true;
	}
	/**
	 * Update doctors visited
	 * @param doc Doctor visited
	 */
	public void updateDoctorsVisited(Doctor doc){
		doctorsVisited.add(doc);
	}
	/**
	 * To rate a Doctor that the Patient visited
	 * @param inputForRating InputInt controller to take in an INT input (DIP)
	 */
	public void rateDoctor(InputInt inputForRating){
		if (doctorsVisited.size() == 0) {
			System.out.println("You have not seen any Doctors yet!");
			return;
		}

		DoctorRatingDisplay.display(doctorsVisited);
		int choice = -1;
		InputInt inputDoctor = new InputIntChoice(doctorsVisited.size());
		choice = inputDoctor.getIntChoice();

		Doctor doctorToBeRated = null;
		int i = 1;
		for(Doctor doctor : doctorsVisited){
			if(i==choice){
				doctorToBeRated = doctor;
				break;
			}
			i++;
		}
		
		DoctorRateDisplay.display(doctorToBeRated);
		choice = inputForRating.getIntChoice();
		UpdateRating.update(doctorToBeRated.getRating(),choice);
		doctorsVisited.remove(doctorToBeRated);
		

	}
}
