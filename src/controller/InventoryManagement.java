package controller;
import java.util.Scanner;

import model.Inventory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class InventoryManagement {
    private ArrayList<Inventory> allInventoryItems; // an array list of all inventory item

    public InventoryManagement(ArrayList<Inventory> allInventoryItems) {
        this.allInventoryItems = allInventoryItems;
    }

    public void manageInventory() {
        int choice=-1;
		boolean validity = false;

        Scanner scan = new Scanner(System.in);
		
		do{
			validity = false;
		      while (!validity) { 
		            try {
		    			System.out.println("1) Add Stocks\r\n"
		    					+ "2) Update Stocks\r\n"
		    					+ "3) Remove Stocks\r\n"
		    					+ "4) Update Alert Line\r\n"
		    					+ "5) Approve Replenishment Requests\r\n"
		    					+ "6) Logout\r\n");
		                System.out.print("Please enter your choice: ");
		                choice = scan.nextInt(); 
		                if(choice>0 && choice<=6) {                	
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
        String medicineName, status;
	    int stockAvailable, alertLevel;

        System.out.println("Enter medicine name");
        medicineName = scan.next();
        System.out.println("Enter updated stock");
        stockAvailable = scan.nextInt();
        scan.next();
        System.out.println("Enter alert level");
        alertLevel = scan.nextInt();
        scan.next();
        System.out.println("Enter status");
        status = scan.next();

        for(Inventory stock : allInventoryItems){
            if (stock.getName().equals(medicineName)){
                stock.setStock(stockAvailable);
                stock.setAlertLevel(alertLevel);
                stock.setStatus(status);
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
            if (stock.getStatus().equals("pending")){
            
                stock.setStatus("approved");
            }
        }
    }
}
