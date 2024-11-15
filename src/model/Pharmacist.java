package model;
import java.util.ArrayList;
import java.util.Scanner;

import model.Inventory.Status;
import model.Prescription.PrescriptionStatus;
import model.Inventory.RequestStatus; 
import view.AppointmentOutcomeRecordDisplay;
import view.InputIntChoice;
import view.InventoryDisplay;
import view.PharmacistDisplayMenu;
import view.PrescriptionDisplay;
import view.ReplenishmentRequestMenu;
import view.UpdatePresriptionStatusMenu;
import view.DisplayLog;
import view.DisplayPrompt;
import view.InputInt;

/** The Pharmacist class represents a pharmacist user who will monitor the prescription status and the supply of medicine.
 * 
 * It provides methods to view appointment outcome record, update prescription status, view inventory, and submit medicine replenishment request.
 */

public class Pharmacist extends User {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private ArrayList<Inventory> allInventoryItems = new ArrayList<>();
    private ArrayList<User> staffList;
    
    /**
	 * Constructs a Pharmacist object with the given details.
	 *
	 * @param id                          the unique ID of the administrator
	 * @param name                        the name of the administrator
	 * @param age                         the age of the administrator
	 * @param gender                      the gender of the administrator
	 * @param allAppointmentOutcomeRecord the list of all appointment outcome record
	 * @param allInventory                the list of all inventory
	 * @param stafflist                   the list of all staffs
	 */

    public Pharmacist(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> allInventoryItems, ArrayList<User> staffList){
        super(id, name, age, gender);
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.allInventoryItems = allInventoryItems;
        this.staffList = staffList;
    }

    /**
	 * Sets the staff list for the pharmacist.
	 *
	 * @param staffList the new list of staff members
	 */

    public void setStaffList(ArrayList<User> staffList) {
        this.staffList = staffList;
    }

    /**
	 * Displays the main menu for the pharmacist and allows interaction
	 * for update prescription status, view appointment and inventory, replenishment requests, and more.
	 */

    public void displayMenu() {         
		
		int choice=-1;
        InputInt input = new InputIntChoice(6);
        System.out.println("");
		DisplayLog.display("WELCOME, " + this.getName() + "!");
		
		do{	
            PharmacistDisplayMenu.display();
            choice = input.getIntChoice();
		        
			/* clear the enter key */ 
            switch(choice) {
            case 1:
                System.out.println("");
                //System.out.println("Appointment Outcome Record:");
                this.viewAppointmentOutcomeRecords();
                break;
            case 2:
                System.out.println("");
               // System.out.println("Update Prescription Status:");
                this.updatePrescriptionStatus();
                break;
        
            case 3:
                System.out.println("");
                // System.out.println("Medication Inventory:");
                this.viewMedicationInventory();
                break;

            case 4:
                System.out.println("");
                System.out.println("Replenishment Request:");
                this.replenishmentRequest();
                break;
            
            case 5:
                showInbox();
                break;

            case 6:
                System.out.println("Logged out successfully!\n");
                break;
            }
        } while (choice != 6);

}

    /** 
     * Display appointment details for all appointments
     */

    public void viewAppointmentOutcomeRecords(){
        String border = "----------------------------------------------";
        System.out.println("");
        if (allAppointmentOutcomeRecords.size() == 0){
            System.out.println("No appointment outcome record!");
            return;
        }
        System.out.printf("%-44s\n", "      Appointment Outcome Record			   ");
        System.out.println(border);
        AppointmentOutcomeRecordDisplay.display(allAppointmentOutcomeRecords);
        System.out.println(border);
        System.out.println("\nQuitting Appointment Outcome Record. . . ");
    }

    /**
     * Check the status of presription first
     * Decide if want to update all prescription status
     * if Yes, the status updated to 'Prescribed' and update the stock quantity
     * if No, move on to the next appointment outcome record
     * if the stock is lower than LowStockAlert, it suggest pharmacist to submit replenishment request
     */

    public void updatePrescriptionStatus(){
        InputInt input = new InputIntChoice(3);
        int choice = -1;

        if (allAppointmentOutcomeRecords.size() == 0){
            System.out.println("No action needed to update prescription status!");
            return;
        }

		
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            System.out.printf("%-44s\n","       Update Prescription Status");
            String border = "----------------------------------------------";
            System.out.println(border);
            boolean updateNeeded = false;
            for (Prescription item : record.getPrescriptionList()){
                if (item.getStatus() == PrescriptionStatus.PENDING){
                    PrescriptionDisplay.display(item);             // use PrescriptionDisplay class
                    updateNeeded = true;
                }
            
            }
            System.out.println(border);
		    System.out.println("");

            if (updateNeeded){
                UpdatePresriptionStatusMenu.display();
                choice = input.getIntChoice();
                System.out.println("");

                
                if (choice == 1){
                    for (Prescription item : record.getPrescriptionList()){
                        this.updateInventory(item);
                    }
                    System.out.println("Next patient record. . .\n");
                }

                if (choice == 2) {
                    System.out.println("");
                    System.out.println("Next patient record. . .");
                    System.out.println("");
                    continue;
                }

                if (choice == 3){
                    break;
                }
            }
        }
        System.out.println("Actions completed!");
        System.out.println("Quitting Prescription Status. . .");
    }

    /**
     * Update inventory if pharmacist decides to prescribe medicine
     * Display the prescription info as acknowledgement
     * @param medicine allowing to do name-matching and update presription status
     */

    private void updateInventory(Prescription medicine) {
        if (medicine.getStatus() == PrescriptionStatus.PENDING){
            for (Inventory stock : allInventoryItems){
                if (stock.getName().equals(medicine.getName())){
                    boolean validity = stock.updateStock();
                    if(validity){
                        medicine.updateStatus();
                    }
                    break;
                }
            }
            PrescriptionDisplay.display(medicine);     // use PrescriptionDisplay class
        }
    }

    /**
     * View medication inventory
     * Check the availability status and quantity of inventory
     */

    public void viewMedicationInventory(){
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "	Current Inventory Information			   ");
		System.out.println(border);
        for (Inventory stock : allInventoryItems){
            InventoryDisplay.display(stock);;            // use InventoryDisplay class
        }
        System.out.println(border);
        System.out.println("\nQuitting Medication Inventory. . .\n");
    }

    /**
     * Display the current inventory information
     * Submit replenishment request to administrator to seek approval
     */

    public void replenishmentRequest(){
        InputInt input = new InputIntChoice(2);
        int choice = -1;

        for(Inventory stock : allInventoryItems){
                String border = "----------------------------------------------";
                System.out.println("");
                System.out.printf("%-44s\n", "	Current Inventory Information			   ");
                System.out.println(border);
                InventoryDisplay.display(stock);;                // use InventoryDisplay class
                System.out.println(border);

                ReplenishmentRequestMenu.display();
                choice = input.getIntChoice();

                if (choice == 1){
                    stock.setreqStatus(RequestStatus.PENDING);
                    InventoryDisplay.display(stock);            // use InventoryDisplay class
                    System.out.println("Submission sent successfully! Waiting approval from administrator.");
                    System.out.println("Next stock. . . ");
                    System.out.println("");
                    sendMessage(getAdmin(), "New replenishment request for " + stock.getName());
                }

                if (choice == 2){
                    System.out.println("");
                    System.out.println("Next stock. . . ");
                    continue;
                }
            }
            System.out.println("Actions Completed!");
            System.out.println("Quitting Replenishment Request. . . ");
    }

    /**
     * Get admin details to send message to admin inbox
     * 
     * return null
     */

    private User getAdmin() {
        for (User user: staffList) {
            /*
             * ASSUME ID of admin starts with 'A'
             */
            if (user.getUserId().charAt(0) == 'A') {
                return user;
            }
        }
        return null;
    }
}
        




