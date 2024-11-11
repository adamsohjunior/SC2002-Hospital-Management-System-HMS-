package controller;
import java.util.Scanner;

import model.Inventory;
import model.Inventory.Status;
import model.Inventory.RequestStatus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import view.InventoryDisplayMenu;
import view.InputIntChoice;


public class InventoryManagement {
    private ArrayList<Inventory> allInventoryItems; // an array list of all inventory item
    private InputIntChoice inputIntChoice = new InputIntChoice(6);

    public InventoryManagement(ArrayList<Inventory> allInventoryItems) {
        this.allInventoryItems = allInventoryItems;
    }

    public void manageInventory() {
        int choice;
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
                break;
            }
		} while (choice != 6);
    }

    private void addStocks() {
        Scanner scan = new Scanner(System.in);
        String medicineName;
	    int stockAvailable, alertLevel;

        System.out.println("Enter medicine name");
        medicineName = scan.next();
        System.out.println("Enter available stock");
        stockAvailable = scan.nextInt();
        scan.next();
        System.out.println("Enter alert level");
        alertLevel = scan.nextInt();
        scan.next();
        

        Inventory inventory = new Inventory(medicineName, stockAvailable, alertLevel);
        allInventoryItems.add(inventory);
    }

    private void updateStocks() {
        Scanner scan = new Scanner(System.in);
        String medicineName;
	    int stockAvailable;

        System.out.println("Enter medicine name");
        medicineName = scan.next();
        System.out.println("Enter updated stock");
        stockAvailable = scan.nextInt();
        scan.next();


        for(Inventory stock : allInventoryItems){
            if (stock.getName().equals(medicineName)){
                stock.setStock(stockAvailable);
                if (stockAvailable > stock.getAlertLevel()) {
                    stock.setStatus(Status.SUFFICIENT);
                }
            } 
        }
    }

    private void removeStocks() {
        Scanner scan = new Scanner(System.in);
        String medicineName;
        System.out.println("Enter medicine name");
        medicineName = scan.next();
        for(Inventory stock : allInventoryItems){
            if (stock.getName().equals(medicineName)){
                allInventoryItems.remove(stock);
            } 
        }
        
    }

    private void updateAlertLine() {
        Scanner scan = new Scanner(System.in);
        String medicineName;
	    int alertLevel;

        System.out.println("Enter medicine name");
        medicineName = scan.next();
        System.out.println("Enter updated alert level");
        alertLevel = scan.nextInt();
        scan.next();

        for(Inventory stock : allInventoryItems){
            if (stock.getName().equals(medicineName)){
                stock.setAlertLevel(alertLevel);              
            } 
        }
    }

    public void approveRequest() {
        for(Inventory stock : allInventoryItems){
            if (stock.getreqStatus() == RequestStatus.PENDING){
            
                stock.setreqStatus(RequestStatus.APPROVED);
            }
        }
    }
}
