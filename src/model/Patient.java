package model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import view.AppointmentOutcomeRecordDisplay;
import view.AppointmentsDisplay;
import view.EmailUpdateDisplay;
import view.InputEmail;
import view.InputIntChoice;
import view.MedicalRecordDisplay;
import view.PatientDisplayMenu;
import view.DisplayLog;
import view.DisplayPrompt;

public class Patient extends User{
	private MedicalRecord medicalRecord;
	private ArrayList<Appointment> scheduledAppointments = new ArrayList<>();
	private Available availableDates;
	private ArrayList<AppointmentOutcomeRecord> appointmentOutcomeRecords = new ArrayList<>();
	private ArrayList<Appointment> allAppointments;
	

	
	/* this availableDates is the global object that itself store an array of ALL Availability objects->days indicated by all doctors that
	 * they are able. We have this to use later on in the scheduling methods.
	 * 
	 * the allAppointments is the global array for ALL appointments for ALL patient. This is really mainly for the Admin class as stated in manual they can access ALL appointment in real-time
	 * */
	
	// removed contactNumber
	public Patient(String id, String name, int age, String email, String bloodType, String dateOfBirth, Available availableDates, String gender, ArrayList<Appointment> allAppointments) {
		
		super(id,name,age,gender);

		medicalRecord = new MedicalRecord(id,name,email,bloodType,dateOfBirth,gender);
		this.allAppointments = allAppointments;
		this.availableDates = availableDates;
	}
	
	public void displayMenu() {
		/* to be filled */
		
		int choice=-1;
		InputIntChoice inputForMenu = new InputIntChoice(9);
		
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
		    	  break;
		      }
		} while (choice != 9);
		
		// scan.close();
	}
	
	/* Getters function that will be removed or not later*/
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	
	public ArrayList<Appointment> getScheduledAppointments(){
		return scheduledAppointments;
	}
	
	public void updateAppointmentOutcomeRecords(Appointment appoinment) {
		scheduledAppointments.remove(appoinment);
		AppointmentOutcomeRecord outcome = appoinment.getAppointmentOutcome();
		appointmentOutcomeRecords.add(outcome);
	}
	
	public void viewMedicalRecord() {
		MedicalRecordDisplay.display(medicalRecord);
	}
	
	public void updatePersonalInfo(String newEmailString) {
		medicalRecord.updateRecord(newEmailString);
	}
	
	public void updatePatientOutcome(AppointmentOutcomeRecord outcome){
		this.appointmentOutcomeRecords.add(outcome);
	}

	public void viewAppointmentOutcomeRecords() {
		if(this.appointmentOutcomeRecords.size() == 0) {
			DisplayLog.display("There are no records.");
			return;
		}
		AppointmentOutcomeRecordDisplay.display(appointmentOutcomeRecords);
	}
	
	public void viewScheduledAppointments() {
		if(this.scheduledAppointments.size()==0) {
			DisplayLog.display("There are no appointments.");
			return;
		}
		AppointmentsDisplay.display(scheduledAppointments);
	}
	
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
	
	public void rescheduleAppointment() {
		
		if (cancelAppointment()) {
			scheduleAppointment();
		}
		else {
			DisplayLog.display("There are no appointments to reschedule");
		}

	}
	
	public boolean cancelAppointment() {
		if(this.scheduledAppointments.size() == 0) {
			DisplayLog.display("There are no appointments to cancel");
			return false;
		}
		
		
		AppointmentsDisplay.display(scheduledAppointments);

		int choice = 0;
		DisplayPrompt.display("Please select an appointment to cancel: ");
		InputIntChoice inputForAppointment = new InputIntChoice(scheduledAppointments.size());
		choice  = inputForAppointment.getIntChoice();
     
		choice = choice-1;
		Appointment appoinmentToBeRemoved = this.scheduledAppointments.get(choice);
		this.scheduledAppointments.remove(appoinmentToBeRemoved);
		

		Doctor doc = appoinmentToBeRemoved.getDoctor();
		String dat = appoinmentToBeRemoved.getDate();
		String tim = appoinmentToBeRemoved.getTime();
		
		doc.removeIncommingAppointment(appoinmentToBeRemoved);
		sendMessage(appoinmentToBeRemoved.getDoctor(), appoinmentToBeRemoved.getPatient().getName()+" has CANCELLED an appointment on "+appoinmentToBeRemoved.getDate()+" "+appoinmentToBeRemoved.getTime());
		this.availableDates.updateAvailableDates(doc, dat, tim);
		return true;
	}
}
