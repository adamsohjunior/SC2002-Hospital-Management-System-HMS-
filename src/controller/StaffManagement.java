package controller;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Formatter;
import model.User;
import model.Administrator;
import model.Appointment;
import model.AppointmentOutcomeRecord;
import model.Available;
import model.Doctor;
import model.Inventory;
import model.Pharmacist;
import view.InputIntChoice;
import view.StaffDisplay;
import view.RoleDisplayMenu;
import view.StaffMDisplayMenu;
import system.SystemManager;

public class StaffManagement {
    private ArrayList<User> staffList;
    private ArrayList<Inventory> allInventoryItems;
    private ArrayList<Appointment> allAppointments;
    private InputIntChoice inputRoleChoice = new InputIntChoice(4);
    private InputIntChoice inputIntChoice = new InputIntChoice(5);
    private SystemManager systemManager;

    public StaffManagement(ArrayList<User> staffList, ArrayList<Inventory> allInventoryItems, ArrayList<Appointment> allAppointments, SystemManager systemManager) {
        this.staffList = staffList;
        this.allInventoryItems = allInventoryItems;
        this.allAppointments = allAppointments;
        this.systemManager = systemManager;
    }

    public void manageStaff() {
        int choice;
        Scanner scan = new Scanner(System.in);

		do{
            StaffMDisplayMenu.display();
            choice = inputIntChoice.getIntChoice();
		    switch(choice) {
		        case 1:
                    addStaff();
                    break;
                case 2:
                    updateStaff();
                    break;
                case 3:
                    removeStaff();
                    break;
                case 4:
                    displayStaff();
		    	    break;
                case 5: 
                    break;
		    }
		} while (choice != 5);
    }

    // add staff
    private void addStaff() {
        Scanner scan = new Scanner(System.in);

        int choice;
        RoleDisplayMenu.display();
        choice = inputRoleChoice.getIntChoice();

        String name, gender, role = null; 
        int age;
        System.out.println("Enter name: ");
        name = scan.next();
        System.out.println("Enter gender: ");
        gender = scan.next();
        System.out.println("Enter age: ");
        age = scan.nextInt();
        //scan.next();
        //System.out.println("Staff selected\n");
        // store data into database
        switch (choice) {           
            case 1: 
                role = "Doctor";
                break;
            case 2: 
                role = "Pharmacists";
                break;
            case 3:
                role = "Admin";
                break;
            default: 
                System.out.println("Invalid Staff Role");
        }
        System.out.println("Staff selected\n");
        User staffMember = createStaff(role, name, age, gender);  
    
        
        if (staffMember != null) {
           int pos = Integer.parseInt(generateId(role, 2)); 
           staffList.add(pos, staffMember);
        }  
        else {
            System.out.println("Invalid Staff Role");
        }
    }

    // Factory method to create staff members
    private User createStaff(String role, String name, int age, String gender) {
        String id = generateId(role, 1);
        ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords = new ArrayList<>();
        Available availableDates = new Available();

        switch (role) {
            case "Doctor":           
                return new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, allInventoryItems);
            case "Pharmacists":
                return new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, allInventoryItems, staffList);
            case "Administrator":
                return new Administrator(id, name, age, gender, allInventoryItems, staffList, allAppointments, systemManager);
            default: 
                return null;
        }
    }

    // Method to generate sequential IDs with leading zeros
    private String generateId(String role, int choice) {
        // choice = 1, return Id
        // choice = 2, return End + 1
        int start = 0, end = 0, index = 0, cnt = 0, size = staffList.size();
        char id = role.charAt(0);
        while (index < size) {
            //check the first character of UserId and Role
            if (staffList.get(cnt).getUserId().charAt(0) == id) {
                if (cnt == 0) { // first element
                    start = index;
                    end = start;
                }
                else {
                    end++;
                }
                cnt++; // increment the number of the role
            }
            else {
                index++;
            }
        }
        if (choice == 1) {
            return id + String.format("%03d", end + 1);  
        }
        if (choice == 2) {
            return String.valueOf(end + 1);
        } 
        return null;
    }


    //update staff
    private void updateStaff() {
        String name, gender, id; int age;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Staff ID");
        id = scan.next();

        // TODO
        // some ways to check if id is valid...
        for (User staff : staffList) {
            if(staff.getUserId().equals(id)) {
                System.out.println("Update name: ");
                name = scan.next();
                System.out.println("Update gender: ");
                gender = scan.next();
                System.out.println("Update age: ");
                age = scan.nextInt();
                scan.next();

                staff.setName(name);
                staff.setGender(gender);
                staff.setAge(age);
            }
        }

    }

    // remove staff
    private void removeStaff() {
        // TODO
        Scanner scan = new Scanner(System.in);
        String id;
        System.out.println("Enter Staff's ID: ");
        id = scan.next();
        for (User staff : staffList) {
            if (staff.getUserId().equals(id)) {
                staffList.remove(staff);
            }
        }
    }

    // display staff
    private void displayStaff() {
        StaffDisplay.display(staffList);
    }
}
