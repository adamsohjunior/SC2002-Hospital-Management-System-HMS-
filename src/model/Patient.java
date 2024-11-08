package model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient extends User{
	private MedicalRecord medicalRecord;
	private ArrayList<Appointment> scheduledAppointments = new ArrayList<>();
	private Available availableDates;
	private ArrayList<AppointmentOutcomeRecord> appointmentOutcomeRecords = new ArrayList<>();
	private ArrayList<Appointment> allAppointments;
	private Scanner scan = new Scanner(System.in);
	
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
		boolean validity = false;
		
		do{
			validity = false;
		      while (!validity) { 
		            try {
		    			System.out.println("1) View Medical Record\r\n"
		    					+ "2) Update Personal Information\r\n"
		    					+ "3) View Available Appointment Slots\r\n"
		    					+ "4) Schedule an Appointment\r\n"
		    					+ "5) Reschedule an Appointment\r\n"
		    					+ "6) Cancel an Appointment\r\n"
		    					+ "7) View Scheduled Appointments\r\n"
		    					+ "8) View Past Appointment Outcome Records\r\n"
		    					+ "9) Logout\r\n");
		                System.out.print("Please enter your choice: ");
		                choice = scan.nextInt(); 
		                if(choice > 0 && choice <= 9) {
		                	validity = true;
		                }
		                else {
		                	System.out.println("Please input a choice that is valid.");
		                }
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input! Please enter an appropriate choice.");
		                scan.next(); 
		            }
		        }
				/* clear the enter key */
				scan.nextLine(); 
		      switch(choice) {
		      case 1:
		    	  viewMedicalRecord();
		    	  break;
		      case 2:
		    	//   boolean proof = false;
		    	//   int contact = -1;
		    	  
		    	  System.out.print("Please input new email: ");
		    	  String email = scan.nextLine();
		    	  
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
		medicalRecord.printRecord();
	}
	
	public void updatePersonalInfo(String newEmailString) {
		medicalRecord.updateRecord(newEmailString);
	}
	
	public void updatePatientOutcome(AppointmentOutcomeRecord outcome){
		this.appointmentOutcomeRecords.add(outcome);
	}

	public void viewAppointmentOutcomeRecords() {
		if(this.appointmentOutcomeRecords.size() == 0) {
			System.out.println("There are no records.");
			return;
		}
		for(int i =0;i<this.appointmentOutcomeRecords.size();i++) {
			this.appointmentOutcomeRecords.get(i).printInfo();
			System.out.println("");
		}
	}
	
	public void viewScheduledAppointments() {
		if(this.scheduledAppointments.size()==0) {
			System.out.println("There are no appointments.");
			return;
		}
		for(int i =0;i<this.scheduledAppointments.size();i++) {
			this.scheduledAppointments.get(i).printInfo();
			System.out.println("");
		}
	}
	
	public void scheduleAppointment() {
		Appointment appointment = availableDates.selectAvailableSlot(scheduledAppointments,this);
		if (appointment == null){ 
			return; 
		}
		scheduledAppointments.add(appointment);
		/* this is a reference to the global appointment list that all classes can access as it is in the main system */
		allAppointments.add(appointment);
		
	}
	
	public void rescheduleAppointment() {
		
		if (cancelAppointment()) {
			scheduleAppointment();
		}
		else {
			System.out.println("There are no appointments to reschedule");
		}
		
	}
	
	public boolean cancelAppointment() {
		if(this.scheduledAppointments.size() == 0) {
			System.out.println("There are no appointments to cancel");
			return false;
		}
		
		System.out.println("Current scheduled appointments");
		for(int i=0;i<this.scheduledAppointments.size();i++) {
			System.out.println((i+1)+")Doctor: "+this.scheduledAppointments.get(i).getDoctor().getName());
			System.out.println("    Date: "+this.scheduledAppointments.get(i).getDate());
			System.out.println("    Time: "+this.scheduledAppointments.get(i).getTime());
		}
		
		boolean validity = false;
		int choice = 0;
		while (!validity) { 
            try {
                System.out.print("Please select an appointment to cancel: ");
                choice = scan.nextInt(); 
                if(choice>0 && choice<=this.scheduledAppointments.size()) {        	
                	validity = true;         	
                }
                else {
                	System.out.println("Please input a choice that is valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an appropriate choice.");
                scan.next(); 
            }
        }
		/* clear the enter key */
		scan.nextLine(); 
		choice = choice-1;
		Appointment appoinmentToBeRemoved = this.scheduledAppointments.get(choice);
		this.scheduledAppointments.remove(appoinmentToBeRemoved);
		

		Doctor doc = appoinmentToBeRemoved.getDoctor();
		String dat = appoinmentToBeRemoved.getDate();
		String tim = appoinmentToBeRemoved.getTime();
		
		doc.removeIncommingAppointment(appoinmentToBeRemoved);

		this.availableDates.updateAvailableDates(doc, dat, tim);
		return true;
	}
}
