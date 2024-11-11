package model;
import java.util.ArrayList;
import java.util.Scanner;

import view.AppointmentOutcomeRecordDisplay;
import view.InputIntChoice;
import view.InventoryDisplay;
import view.PharmacistDisplayMenu;
import view.PrescriptionDisplay;
import view.ReplenishmentRequestMenu;
import view.UpdatePresriptionStatusMenu;

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
        InputIntChoice input = new InputIntChoice(5);
		
		do{	
            PharmacistDisplayMenu.display();
            choice = input.getIntChoice();
		        
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

}

    public void viewAppointmentOutcomeRecords(){
        AppointmentOutcomeRecordDisplay.display(allAppointmentOutcomeRecords);
        System.out.println("Quitting Appointment Outcome Record. . . ");
    }


    public void updatePrescriptionStatus(){
        InputIntChoice input = new InputIntChoice(3);
        int choice = -1;

        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            boolean updateNeeded = false;
            for (Prescription item : record.getPrescriptionList()){
                if (item.getStatus().equals( "Pending")){
                    PrescriptionDisplay.display(item);             // use PrescriptionDisplay class
                    System.out.println("");
                    updateNeeded = true;
                }
            }

            if (updateNeeded){
                UpdatePresriptionStatusMenu.display();
                choice = input.getIntChoice();

                
                if (choice == 1){
                    for (Prescription item : record.getPrescriptionList()){
                        this.updateInventory(item);
                    }
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
            PrescriptionDisplay.display(medicine);     // use PrescriptionDisplay class
        }
    }


    public void viewMedicationInventory(){
        for (Inventory stock : allInventoryItems){
            InventoryDisplay.display(stock);;            // use InventoryDisplay class
        }

        System.out.println("Quitting Medication Inventory. . .");
    }

    public void replenishmentRequest(){
        InputIntChoice input = new InputIntChoice(2);
        int choice = -1;

        for(Inventory stock : allInventoryItems){
            if (stock.getStatus().equals("low")){
                InventoryDisplay.display(stock);;                // use InventoryDisplay class

                ReplenishmentRequestMenu.display();
                choice = input.getIntChoice();

                if (choice == 1){
                    stock.setreqStatus("pending");
                    InventoryDisplay.display(stock);            // use InventoryDisplay class
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
