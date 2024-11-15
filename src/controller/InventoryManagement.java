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

/**
 * Manages all operations related to inventory management in the system.
 * This includes adding, updating, removing inventory items, managing alert levels,
 * approving requests, and displaying inventory details.
 *
 * <p>
 * The class operates on a list of {@link model.Inventory} objects and provides an
 * interactive menu for users to perform inventory operations.
 * </p>
 */
public class InventoryManagement {
    private ArrayList<Inventory> allInventoryItems; // An array list of all inventory items

    /**
     * Constructs an InventoryManagement object with the provided list of inventory items.
     *
     * @param allInventoryItems the list of all inventory items to manage
     */
    public InventoryManagement(ArrayList<Inventory> allInventoryItems) {
        this.allInventoryItems = allInventoryItems;
    }

    /**
     * Displays a menu for managing inventory and processes user input for performing
     * various inventory-related operations.
     */
    public void manageInventory() {
        int choice;
        InputIntChoice inputIntChoice = new InputIntChoice(7);
        do {
            InventoryDisplayMenu.display();
            choice = inputIntChoice.getIntChoice();

            switch (choice) {
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

    /**
     * Adds a new inventory item to the list by collecting user input for item details
     * such as name, stock level, and alert level.
     */
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

        Inventory inventory = new Inventory(medicineName, stockAvailable, alertLevel);
        allInventoryItems.add(inventory);
    }

    /**
     * Updates the stock level of a specific inventory item selected by the user.
     * Also updates the status of the item based on the new stock level.
     */
    private void updateStocks() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice, stockAvailable;
        InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size());

        System.out.println("Select medicine to be updated");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        System.out.println("Enter updated stock");
        stockAvailable = scan.nextInt();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        stock.setStock(stockAvailable);
        if (stockAvailable > stock.getAlertLevel()) {
            stock.setStatus(Status.SUFFICIENT);
        }
    }

    /**
     * Removes an inventory item from the list based on user selection.
     */
    private void removeStocks() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice;
        InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size());

        System.out.println("Select medicine to be removed");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        allInventoryItems.remove(stock);
    }

    /**
     * Updates the alert level of a specific inventory item selected by the user.
     */
    private void updateAlertLine() {
        Scanner scan = new Scanner(System.in);
        int medicineChoice, alertLevel;
        InputIntChoice inputIntChoice = new InputIntChoice(allInventoryItems.size());

        System.out.println("Select medicine to update alert level");
        MedicineDisplay.display(allInventoryItems);
        medicineChoice = inputIntChoice.getIntChoice();

        System.out.println("Enter updated alert level");
        alertLevel = scan.nextInt();

        Inventory stock = allInventoryItems.get(medicineChoice - 1);
        stock.setAlertLevel(alertLevel);
    }

    /**
     * Approves all pending inventory requests by setting their request status to APPROVED.
     */
    public void approveRequest() {
        boolean need = false;
        for(Inventory stock : allInventoryItems){
            if (stock.getreqStatus() == RequestStatus.PENDING){
                need = true;
                stock.setreqStatus(RequestStatus.APPROVED);
            }
        }
        if(!need){
            System.out.println("\nNo actions needed!\n");
        }
    }

    /**
     * Displays the details of all inventory items by using a view helper class.
     */
    private void displayInventory() {
        String border = "----------------------------------------------";
        System.out.println("");
        System.out.printf("%-44s\n", "	Current Inventory Information			   ");
        System.out.println(border);
        for (Inventory item : allInventoryItems) {
            InventoryDisplay.display(item);;                // use InventoryDisplay class
     }

     System.out.println(border);
    }
}
