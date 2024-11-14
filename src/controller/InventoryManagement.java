package controller;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import model.Inventory;
import model.Inventory.Status;
import model.Inventory.RequestStatus;

import view.InventoryDisplayMenu;
import view.InventoryDisplay;
import view.MedicineDisplay;
import view.InputIntChoice;


public class InventoryManagement {
    private ArrayList<Inventory> allInventoryItems; // an array list of all inventory item
   
    public InventoryManagement(ArrayList<Inventory> allInventoryItems) {
        this.allInventoryItems = allInventoryItems;
    }

    public void manageInventory() {
        int choice;
        InputIntChoice inputIntChoice = new InputIntChoice(7);
		do{
            InventoryDisplayMenu.display();
            choice = inputIntChoice.getIntChoice();
            
            switch(choice) {
            case 1:
                addStocks();
                break;
            case 2:
                updateStocks();
                break;
            case 3:
                removeStocks();
                break;
            case 4:
                updateAlertLine();
                break;
            case 5:
                approveRequest();
                break;
            case 6:
                displayInventory();
                break;
            case 7: 
                break;    
            }      
		} while (choice != 7);
    }

    private void addStocks() {
        Scanner scan = new Scanner(System.in);
        String medicineName;
	    int stockAvailable, alertLevel;

        System.out.println("Enter medicine name");
        medicineName = scan.next();
        System.out.println("Enter available stock");
        stockAvailable = scan.nextInt();
        System.out.println("Enter alert level");
        alertLevel = scan.nextInt();
        //scan.nextLine();

        Inventory inventory = new Inventory(medicineName, stockAvailable, alertLevel);
        allInventoryItems.add(inventory);
    }

    private void updateStocks() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice, stockAvailable;
	    InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size()) ;

        System.out.println("Select medicine to be updated");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        System.out.println("Enter updated stock");
        stockAvailable = scan.nextInt();
        //scan.next();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        stock.setStock(stockAvailable);
        if (stockAvailable > stock.getAlertLevel()) {
            stock.setStatus(Status.SUFFICIENT);
        }

    }

    private void removeStocks() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice;
	    InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size()) ;

        System.out.println("Select medicine to be updated");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        allInventoryItems.remove(stock);
        
        
    }

    private void updateAlertLine() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice, alertLevel;
	    InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size()) ;

        System.out.println("Select medicine to be updated");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        System.out.println("Enter updated alert level");
        alertLevel = scan.nextInt();
        //scan.next();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        stock.setAlertLevel(alertLevel);              
             
    }

    public void approveRequest() {
        for(Inventory stock : allInventoryItems){
            if (stock.getreqStatus() == RequestStatus.PENDING){
            
                stock.setreqStatus(RequestStatus.APPROVED);
            }
        }
    }

    private void displayInventory() {
        for (Inventory item : allInventoryItems) {
            InventoryDisplay.display(item);
        }
    }
}
