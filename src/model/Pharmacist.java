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

public class Pharmacist extends User {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private ArrayList<Inventory> allInventoryItems = new ArrayList<>();
    private ArrayList<User> staffList;
    
    public Pharmacist(String id, String name, int age, String gender, Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> allInventoryItems, ArrayList<User> staffList){
        super(id, name, age, gender);
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.allInventoryItems = allInventoryItems;
        this.staffList = staffList;
    }

    public void setStaffList(ArrayList<User> staffList) {
        this.staffList = staffList;
    }

    public void displayMenu() {         // use PharmascistDisplayMenu class
		/* To be done */
		
		int choice=-1;
        InputIntChoice input = new InputIntChoice(5);
		
		do{	
            PharmacistDisplayMenu.display();
            choice = input.getIntChoice();
		        
				/* clear the enter key */
			// scan.nextLine(); 
            switch(choice) {
            case 1:
                System.out.println("");
                System.out.println("Appointment Outcome Record:");
                this.viewAppointmentOutcomeRecords();
                break;
            case 2:
                System.out.println("");
                System.out.println("Update Prescription Status:");
                this.updatePrescriptionStatus();
                break;
        
            case 3:
                System.out.println("");
                System.out.println("Medication Inventory:");
                this.viewMedicationInventory();
                break;

            case 4:
                System.out.println("");
                System.out.println("Replenishment Request:");
                this.replenishmentRequest();
                break;

            case 5:
                System.out.println("");
                System.out.println("Pharmacist logging out . . . ");
                break;
            }
        }while(choice != 5);

}

    public void viewAppointmentOutcomeRecords(){
        AppointmentOutcomeRecordDisplay.display(allAppointmentOutcomeRecords);
        System.out.println("Quitting Appointment Outcome Record. . . ");
    }


    public void updatePrescriptionStatus(){
        InputIntChoice input = new InputIntChoice(3);
        int choice = -1;

        if (allAppointmentOutcomeRecords.size() == 0){
            System.out.println("No action needed to update prescription status!");
            return;
        }

		
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            System.out.println("==============================================");
            boolean updateNeeded = false;
            for (Prescription item : record.getPrescriptionList()){
                if (item.getStatus() == PrescriptionStatus.PENDING){
                    PrescriptionDisplay.display(item);             // use PrescriptionDisplay class
                    updateNeeded = true;
                }
            
            }
            System.out.println("==============================================");
		    System.out.println("");

            if (updateNeeded){
                UpdatePresriptionStatusMenu.display();
                choice = input.getIntChoice();
                System.out.println("");

                
                if (choice == 1){
                    for (Prescription item : record.getPrescriptionList()){
                        this.updateInventory(item);
                    }
                    System.out.println("Next patient record. . .");
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


    public void viewMedicationInventory(){
        System.out.println("Current Inventory Information: ");
		System.out.println("==============================================");
        for (Inventory stock : allInventoryItems){
            InventoryDisplay.display(stock);;            // use InventoryDisplay class
        }
        System.out.println("==============================================");
        System.out.println("Quitting Medication Inventory. . .");
    }

    public void replenishmentRequest(){
        InputIntChoice input = new InputIntChoice(2);
        int choice = -1;

        for(Inventory stock : allInventoryItems){
                System.out.println("Current Inventory Information: ");
                System.out.println("==============================================");
                InventoryDisplay.display(stock);;                // use InventoryDisplay class
                System.out.println("==============================================");

                ReplenishmentRequestMenu.display();
                choice = input.getIntChoice();

                if (choice == 1){
                    stock.setreqStatus(RequestStatus.PENDING);
                    InventoryDisplay.display(stock);            // use InventoryDisplay class
                    System.out.println("Submission sent successfully! Waiting approval from administrator.");
                    System.out.println("Next stock. . . ");
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
        




