package Classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Doctor extends User{

	private ArrayList<MedicalRecord> patientMedicalRecords = new ArrayList<>();
	private Available personalSchedule;
	private Available availableDates;
	private ArrayList<Appointment> appointmentRequests = new ArrayList<>();
	private ArrayList<Appointment> upcomingAppointments = new ArrayList<>();
	private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
	private Scanner scan = new Scanner(System.in);
	
	/* availableDates is same with patient, here is where we are able to update it for patient use
	 * 
	 * allAppointmentOutcomeRecords is the global list for all appointmentoutcomerecords. Since the doctor is the one making this class (see method below) when they want to 'complete' the appointment
	 * and write up on diagnoses,treatment,pres...etc, they will make a AppointmentOutcomeRecord object. This object is stored in both the current appointment object and this global list.
	 * This global list is then ACCESSED by PHARMACISTS so they can do their job of prescribing the medicine, update status, etc.
	 */
	
	
	public Doctor(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords) {
		super(id,name,age,gender);
		personalSchedule = new Available();
		this.availableDates = availableDates;
		this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
	}
	
	public void displayMenu() {
		/* To be done */
		
		int choice=-1;
		boolean validity = false;
		
		do{
			validity = false;
		      while (!validity) { 
		            try {
		    			System.out.println("1)View Patient Medical Records\r\n"
		    					+ "2) Update Patient Medical Records\r\n"
		    					+ "3) View Personal Schedule\r\n"
		    					+ "4) Set Availability for Appointments\r\n"
		    					+ "5) Accept or Decline Appointment Requests\r\n"
		    					+ "6) View Upcoming Appointments\r\n"
		    					+ "7) Record Appointment Outcome\r\n"
		    					+ "8) Logout\r\n");
		                System.out.print("Please enter your choice: ");
		                choice = scan.nextInt(); 
		                if(choice>0 && choice<=8) {
		                
		                	
		                	validity = true;
		             
		                	
		                }
		                else {
		                	System.out.print("Please input a choice that is valid.");
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
		    	  break;

		      }
		
		            
		
		}while(choice != 8);
		
		scan.close();
	}
	
	public void viewPersonalSchedule() {
		personalSchedule.viewAvailableAppointmentSlots();
	}
	
	public void viewPatientMedicalRecords() {
		for(int j = 0;j<patientMedicalRecords.size();j++) {
			patientMedicalRecords.get(j).printRecord();
			System.out.println("");
		}
	}
	
	public void updatePatientMedicalRecord() {
		if(patientMedicalRecords.size()==0) {
			System.out.println("You have no patients");
			return;
		}
		
		System.out.println("Select patient to update their record");
		for(int i=0;i<patientMedicalRecords.size();i++) {
			System.out.println((i+1)+")"+patientMedicalRecords.get(i).getName());
		}
		
		boolean validity = false;
		int choice =-1;
	      while (!validity) { 
	            try {

	                System.out.print("Please enter your choice: ");
	                choice = scan.nextInt(); 
	                if(choice>0 && choice<=patientMedicalRecords.size()) {
	                
	                	
	                	validity = true;
	             
	                	
	                }
	                else {
	                	System.out.print("Please input a choice that is valid.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter an appropriate choice.");
	                scan.next(); 
	            }
	        }
			/* clear the enter key */
			scan.nextLine(); 
			choice = choice-1;
			System.out.println("Please enter today's date(DD-MMM): ");
			String date = scan.nextLine();
			System.out.println("Please enter your diagnoses: ");
			String diag = scan.nextLine();
			System.out.println("Please enter your treatment: ");
			String treat = scan.nextLine();
			System.out.println("Please enter your consultation notes: ");
			String notes = scan.nextLine();
			
			
			/* here can change to list of medications instead of the doctor manually enterint the name*/
			
			ArrayList<Prescription> list = new ArrayList<>();
			
			validity = false;
			choice = 0;
			while(choice !=2) {
				validity = false;
				while (!validity) { 
		            try {
		            	System.out.println("1)Prescribe Medication");
		            	System.out.println("2)Finish");
		                choice = scan.nextInt(); 
		                if(choice>0 && choice<3) {
		                	
		                	validity = true;
		                	               	
		                }
		                else {
		                	System.out.print("Please input a choice that is valid.");
		                }
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input! Please enter an appropriate choice.");
		                scan.next(); 
		            }
		        }
				
				/* clear the enter key */
				scan.nextLine(); 
				if(choice == 1) {
					System.out.print("Enter name of medication to prescribe: ");
					String medName = scan.nextLine();
					Prescription toBePrescribed = new Prescription(medName);
					list.add(toBePrescribed);
				}
				
			}
			
			AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(date, diag, treat, list, notes);
			patientMedicalRecords.get(choice).updateRecord(outcome);
	}
	
	public void setAvailability() {
		System.out.print("Available Date (DD-MMM): ");
		String date = scan.nextLine();
		
		System.out.print("Available Time (XX:YY): ");
		String time = scan.nextLine();
		
		Availability avail = new Availability(this,date,time);
		/* Both arraylist contains the same ref to Availability object */
		personalSchedule.addAvailableDates(avail);
		availableDates.addAvailableDates(avail);
		
	}
	
	public void incomingAppointment(Appointment appointment) {
		appointmentRequests.add(appointment);
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
			System.out.println("There are no appointment requests.");
			return;
		}
		
		System.out.print("Appointment requests: ");
		for (int i = 0;i<appointmentRequests.size();i++) {
			Appointment temp = appointmentRequests.get(i);
			temp.printInfo();
			
			boolean validity = false;
			int choice = 0;
			while (!validity) { 
	            try {
	            	System.out.println("1 to Accept || 2 to Decline");
	                choice = scan.nextInt(); 
	                if(choice>0 && choice<3) {
	                	
	                	validity = true;
	                	               	
	                }
	                else {
	                	System.out.print("Please input a choice that is valid.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter an appropriate choice.");
	                scan.next(); 
	            }
	        }
			
			/* clear the enter key */
			scan.nextLine(); 
			
			if(choice == 1) {
				temp.setStatus("Accepted");
				upcomingAppointments.add(temp);
				appointmentRequests.remove(temp);
				updatePatientList();
			}
			else {
				temp.setStatus("Rejected");
				appointmentRequests.remove(temp);
				Doctor doc = temp.getDoctor();
				String dat = temp.getDate();
				String tim = temp.getTime();
				
				/* this should update the availability object for both personal and global since both contain the same ref to the object*/
				this.availableDates.updateAvailableDates(doc, dat, tim);
			}

			
		}
		
	}
	
	public void viewUpcomingAppointments() {
		if(upcomingAppointments.size()==0) {
			System.out.println("You have no upcoming appoinments.");
			return;
		}
		
		for(int i =0; i<upcomingAppointments.size();i++) {
			upcomingAppointments.get(i).printInfo();
			System.out.println("");
		}
	}
	
	
	
	public void recordAppointmentOutcome() {
		if(this.upcomingAppointments.size() == 0) {
			System.out.println("There are no appointments to complete");
			return;
		}
		
		System.out.print("Current appointments");
		for(int i=0;i<this.upcomingAppointments.size();i++) {
			System.out.println((i+1)+")Patient: "+this.upcomingAppointments.get(i).getPatient().getName());
			System.out.println("    Date: "+this.upcomingAppointments.get(i).getDate());
			System.out.println("    Time: "+this.upcomingAppointments.get(i).getTime());
		}
		
		boolean validity = false;
		int choice = 0;
		while (!validity) { 
            try {
                System.out.print("Please select an appointment to complete: ");
                choice = scan.nextInt(); 
                if(choice>0 && choice<=this.upcomingAppointments.size()) {
                	
                	validity = true;
                	               	
                }
                else {
                	System.out.print("Please input a choice that is valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an appropriate choice.");
                scan.next(); 
            }
        }
		
		/* clear the enter key */
		scan.nextLine();
		
		choice = choice-1;
		Appointment chosen = upcomingAppointments.get(choice);
		upcomingAppointments.remove(chosen);
		updatePatientList();
		
		System.out.println("Please enter your diagnoses: ");
		String diag = scan.nextLine();
		System.out.println("Please enter your treatment: ");
		String treat = scan.nextLine();
		System.out.println("Please enter your consultation notes: ");
		String notes = scan.nextLine();
		
		
		/* here can change to list of medications instead of the doctor manually enterint the name*/
		
		ArrayList<Prescription> list = new ArrayList<>();
		
		validity = false;
		choice = 0;
		while(choice !=2) {
			validity = false;
			while (!validity) { 
	            try {
	            	System.out.println("1)Prescribe Medication");
	            	System.out.println("2)Finish");
	                choice = scan.nextInt(); 
	                if(choice>0 && choice<3) {
	                	
	                	validity = true;
	                	               	
	                }
	                else {
	                	System.out.print("Please input a choice that is valid.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter an appropriate choice.");
	                scan.next(); 
	            }
	        }
			
			/* clear the enter key */
			scan.nextLine(); 
			if(choice == 1) {
				System.out.print("Enter name of medication to prescribe: ");
				String medName = scan.nextLine();
				Prescription toBePrescribed = new Prescription(medName);
				list.add(toBePrescribed);
			}
			
		}
		
		AppointmentOutcomeRecord outcome = new AppointmentOutcomeRecord(chosen.getDate(), diag, treat, list, notes);
		chosen.updateAppointment(outcome);
		
		/* update the global list so that pharmacists can see and perform their task */
		allAppointmentOutcomeRecords.add(outcome);
		chosen.getPatient().getMedicalRecord().updateRecord(outcome);
		
	}
	

	
}
