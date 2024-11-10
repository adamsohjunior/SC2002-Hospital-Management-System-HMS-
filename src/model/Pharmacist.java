package model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pharmacist extends User{
    private Scanner scan = new Scanner(System.in);
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private ArrayList<Inventory> allInventoryItems;
    
    public Pharmacist(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> allInventoryItems){
        super(id, name, age, gender);
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.allInventoryItems = allInventoryItems;
    }

    public void displayMenu() {         // use PharmascistDisplayMenu class
		/* To be done */
		
		int choice=-1;
		boolean validity = false;
		
		do{
			validity = false;
		      while (!validity) { 
		            try {
		    			System.out.println("1)View Appointment Outcome Record\r\n"
		    					+ "2) Update Prescription Status\r\n"
		    					+ "3) View Medication Inventory\r\n"
		    					+ "4) Submit Replenishment Request\r\n"
		    					+ "5) Logout\r\n");
		                System.out.print("Please enter your choice: ");
		                choice = scan.nextInt(); 
		                if(choice>0 && choice<=5) {
		                
		                	
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
                  System.out.println("Application Outcome Record:");
		    	  this.viewAppointmentOutcomeRecords();
		    	  break;
		      case 2:
                  System.out.println("Prescription Status:");
		    	  this.updatePrescriptionStatus();
		    	  break;
            
              case 3:
                  System.out.println("Medication Inventory:");
                  this.viewMedicationInventory();
		    	  break;

              case 4:
                  System.out.println("Replenishment Request:");
                  this.replenishmentRequest();
                  break;

		      case 5:
                  System.out.println("Pharmacist logging out . . . ");
		    	  break;
		      }
		}while(choice != 5);
		
        // scan.close();

	}

    public void viewAppointmentOutcomeRecords(){
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            record.printInfo();     // use ApppointmentOutcomeRecordDisplay class
            System.out.println(); 
            System.out.println("-------------");
        }
        System.out.println("Quitting Appointment Outcome Record. . . ");
    }


    public void updatePrescriptionStatus(){
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            boolean updateNeeded = false;
            for (Prescription item : record.getPrescriptionList()){
                if (item.getStatus().equals( "Pending")){
                    item.display();             // use PrescriptionDisplay class
                    System.out.println("");
                    updateNeeded = true;
                }
            }

            if (updateNeeded){
                System.out.println("Do you wish to update all prescription status?\r\n"    // use UpdatePresriptionStatusMenu class
                                    + "1. Yes\r\n"
                                    + "2. No\r\n"
                                    + "3. Quit\r\n");
                int options = scan.nextInt();

                
                if (options == 1){
                    for (Prescription item : record.getPrescriptionList()){
                        this.updateInventory(item);
                    }
                    


                }

                if (options == 2) {
                    System.out.println("Next patient record. . .");
                    continue;
                }

                if (options == 3){
                    break;
                }
            }
        }
        System.out.println("Quitting Prescription Status. . .");
    }

    private void updateInventory(Prescription medicine) {
        if (medicine.getStatus().equals("Pending")){
            for (Inventory stock : allInventoryItems){
                if (stock.getName().equals(medicine.getName())){
                    boolean validity = stock.updateStock();
                    if(validity){
                        medicine.updateStatus();
                    }
                    break;
                }
            }
            medicine.display();     // use PrescriptionDisplay class
        }
    }


    public void viewMedicationInventory(){
        for (Inventory stock : allInventoryItems){
            stock.display();            // use InventoryDisplay class
        }

        System.out.println("Quitting Medication Inventory. . .");
    }

    public void replenishmentRequest(){
        for(Inventory stock : allInventoryItems){
            if (stock.getStatus().equals("low")){
                stock.display();                // use InventoryDisplay class

                System.out.println("Submit replenishment request?\r\n"          // use ReplenishmentRequestMenu class
                                    + "1. Yes\r\n"
                                    + "2. No\r\n");

                int choice = scan.nextInt();

                if (choice == 1){
                    stock.setreqStatus("pending");
                    stock.display();            // use InventoryDisplay class
                    System.out.println("Submission sent successfully! Waiting approval from administrator.");
                }

                if (choice == 2){
                    System.out.println("Next stock. . . ");
                    continue;
                }
            } 
        }
        System.out.println("Quitting Replenishment Request. . . ");
    }



}
