import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.AppointmentOutcomeRecord;
import model.Available;
import model.Inventory;
import model.Prescription;
import model.User;

/**
 * The Pharmacist class represents a pharmacist user who can manage 
 * appointments, update prescriptions, and handle medication inventory.
 */
public class testing extends User {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private ArrayList<Inventory> allInventoryItems;

    /**
     * Constructs a new Pharmacist object with the specified attributes.
     *
     * @param id                       The ID of the pharmacist.
     * @param name                     The name of the pharmacist.
     * @param age                      The age of the pharmacist.
     * @param gender                   The gender of the pharmacist.
     * @param availableDates           Available dates for the pharmacist.
     * @param allAppointmentOutcomeRecords List of all appointment outcome records.
     * @param allInventoryItems        List of all inventory items.
     */
    public testing(String id, String name, int age, String gender, Available availableDates, 
                      ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, 
                      ArrayList<Inventory> allInventoryItems) {
        super(id, name, age, gender);
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.allInventoryItems = allInventoryItems;
    }

    /**
     * Displays the menu for pharmacist operations and processes user choices.
     */
    public void displayMenu() {
        int choice = -1;
        boolean validity = false;

        do {
            validity = false;
            while (!validity) { 
                try {
                    System.out.println("1) View Appointment Outcome Record\r\n"
                                     + "2) Update Prescription Status\r\n"
                                     + "3) View Medication Inventory\r\n"
                                     + "4) Submit Replenishment Request\r\n"
                                     + "5) Logout\r\n");
                    System.out.print("Please enter your choice: ");
                    choice = scan.nextInt();
                    if (choice > 0 && choice <= 5) {
                        validity = true;
                    } else {
                        System.out.print("Please input a valid choice.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an appropriate choice.");
                    scan.next();
                }
            }
            scan.nextLine(); // Clear the enter key

            switch (choice) {
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
        } while (choice != 5);
    }

    /**
     * Displays all appointment outcome records.
     */
    public void viewAppointmentOutcomeRecords() {
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            record.printInfo();
            System.out.println();
            System.out.println("-------------");
        }
        System.out.println("Quitting Appointment Outcome Record. . . ");
    }

    /**
     * Allows the pharmacist to update the status of pending prescriptions.
     */
    public void updatePrescriptionStatus() {
        for (AppointmentOutcomeRecord record : allAppointmentOutcomeRecords) {
            boolean updateNeeded = false;
            for (Prescription item : record.getPrescriptionList()) {
                if (item.getStatus().equals("Pending")) {
                    item.display();
                    System.out.println("");
                    updateNeeded = true;
                }
            }

            if (updateNeeded) {
                System.out.println("Do you wish to update all prescription status?\r\n"
                                 + "1. Yes\r\n"
                                 + "2. No\r\n"
                                 + "3. Quit\r\n");
                int options = scan.nextInt();

                if (options == 1) {
                    for (Prescription item : record.getPrescriptionList()) {
                        this.updateInventory(item);
                    }
                }

                if (options == 2) {
                    System.out.println("Next patient record. . .");
                    continue;
                }

                if (options == 3) {
                    break;
                }
            }
        }
        System.out.println("Quitting Prescription Status. . .");
    }

    /**
     * Updates the inventory based on the given prescription, setting the status 
     * of the prescription to "Completed" if the stock is updated successfully.
     *
     * @param medicine The prescription to update in the inventory.
     */
    private void updateInventory(Prescription medicine) {
        if (medicine.getStatus().equals("Pending")) {
            for (Inventory stock : allInventoryItems) {
                if (stock.getName().equals(medicine.getName())) {
                    boolean validity = stock.updateStock();
                    if (validity) {
                        medicine.updateStatus();
                    }
                    break;
                }
            }
            medicine.display();
        }
    }

    /**
     * Displays the current status of the medication inventory.
     */
    public void viewMedicationInventory() {
        for (Inventory stock : allInventoryItems) {
            stock.display();
        }
        System.out.println("Quitting Medication Inventory. . .");
    }

    /**
     * Checks inventory for low stock and allows the pharmacist to submit 
     * replenishment requests for items with low status.
     */
    public void replenishmentRequest() {
        for (Inventory stock : allInventoryItems) {
            if (stock.getStatus().equals("low")) {
                stock.display();

                System.out.println("Submit replenishment request?\r\n"
                                 + "1. Yes\r\n"
                                 + "2. No\r\n");

                int choice = scan.nextInt();

                if (choice == 1) {
                    stock.setStatus("pending");
                    stock.display();
                    System.out.println("Submission sent successfully! Waiting approval from administrator.");
                }

                if (choice == 2) {
                    System.out.println("Next stock. . . ");
                    continue;
                }
            } 
        }
        System.out.println("Quitting Replenishment Request. . . ");
    }
}
