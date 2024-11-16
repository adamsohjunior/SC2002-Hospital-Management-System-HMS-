package controller;

import java.util.Scanner;
import java.util.ArrayList;
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
import view.DisplayGender;
import view.InputID;
import system.SystemManager;
import view.InputInt;

/**
 * Manages the staff operations within the hospital management system, including
 * adding, updating, removing, and displaying staff members. The class provides
 * functionality for handling various roles (e.g., Doctor, Pharmacist, Administrator)
 * and ensures each staff member is registered, tracked, and updated as needed.
 *
 * <p>
 * Utilizes user input for interactive management of staff members and connects
 * with various views to display information and receive user selections.
 * </p>
 */
public class StaffManagement {

    private ArrayList<User> staffList;
    private ArrayList<Inventory> allInventoryItems;
    private ArrayList<Appointment> allAppointments;
    private InputInt inputRoleChoice = new InputIntChoice(4);
    private InputInt inputIntChoice = new InputIntChoice(5);
    private InputInt inputGenderChoice = new InputIntChoice(3);
    private SystemManager systemManager;

    /**
     * Constructs a StaffManagement object with lists of staff, inventory items,
     * and appointments, and initializes the system manager.
     *
     * @param staffList         the list of all staff members
     * @param allInventoryItems the list of all inventory items
     * @param allAppointments   the list of all appointments
     * @param systemManager     the system manager for handling system-wide operations
     */
    public StaffManagement(ArrayList<User> staffList, ArrayList<Inventory> allInventoryItems,
                           ArrayList<Appointment> allAppointments, SystemManager systemManager) {
        this.staffList = staffList;
        this.allInventoryItems = allInventoryItems;
        this.allAppointments = allAppointments;
        this.systemManager = systemManager;
    }

    /**
     * Manages the interactive menu for performing staff operations such as adding,
     * updating, removing, and displaying staff members. Processes user selections
     * to direct control to the appropriate operation.
     */
    public void manageStaff() {
        int choice;

        do {
            StaffMDisplayMenu.display();
            choice = inputIntChoice.getIntChoice();
            switch (choice) {
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

    /**
     * Adds a new staff member by gathering user input for role, name, gender, and age.
     * The method then creates a new instance of the specified role and adds it to
     * the staff list.
     */
    private void addStaff() {
        Scanner scan = new Scanner(System.in);

        int choice;
        RoleDisplayMenu.display();
        choice = inputRoleChoice.getIntChoice();

        String name, gender = null, role = null;
        int age;
        System.out.println("Enter name: ");
        name = scan.next();

        DisplayGender.display();
        int choiceGen = inputGenderChoice.getIntChoice();
        switch (choiceGen) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Prefer not to say";
                break;
            default:
                System.out.println("Invalid gender choice");
        }

        System.out.println("Enter age: ");
        age = scan.nextInt();

        // Assign role based on choice
        switch (choice) {
            case 1:
                role = "Doctor";
                break;
            case 2:
                role = "Pharmacist";
                break;
            case 3:
                role = "Admin";
                break;
            default:
                System.out.println("Invalid Staff Role");
        }

        User staffMember = createStaff(role, name, age, gender);
        if (staffMember != null) {
            int pos = Integer.parseInt(generateId(role, 2));
            staffList.add(pos, staffMember);
            systemManager.addUser(staffMember);
            System.out.println("Staff Added...");
        } else {
            System.out.println("Invalid Staff Role");
        }
    }

    /**
     * Factory method that creates a staff member object based on the specified role.
     *
     * @param role   the role of the staff member (Doctor, Pharmacist, Admin)
     * @param name   the name of the staff member
     * @param age    the age of the staff member
     * @param gender the gender of the staff member
     * @return a new User object representing the staff member, or null if the role is invalid
     */
    private User createStaff(String role, String name, int age, String gender) {
        String id = generateId(role, 1);
        ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords = new ArrayList<>();
        Available availableDates = new Available();

        switch (role) {
            case "Doctor":
                return new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, allInventoryItems);
            case "Pharmacist":
                return new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, allInventoryItems, staffList);
            case "Admin":
                return new Administrator(id, name, age, gender, allInventoryItems, staffList, allAppointments, systemManager);
            default:
                return null;
        }
    }

    /**
     * Generates a sequential ID for staff members based on their role, with leading
     * zeros for formatting. The generated ID includes the first character of the role.
     *
     * @param role   the role of the staff member
     * @param choice determines if the method should return the ID (1) or the insertion index (2)
     * @return the generated ID or index as a String
     */
    private String generateId(String role, int choice) {
        int start = 0, end = 0, index = 0, cnt = 0, size = staffList.size();
        char id = role.charAt(0);
        while (index < size) {
            if (staffList.get(index).getUserId().charAt(0) == id) {
                if (cnt == 0) {
                    start = index;
                    end = start;
                } else {
                    end++;
                }
                cnt++;
            }
            index++;
        }

        if (choice == 1) {
            return id + String.format("%03d", cnt + 1);
        }
        if (choice == 2) {
            return String.valueOf(end + 1);
        }
        return null;
    }

    /**
     * Updates details of an existing staff member by modifying their name, gender, and age.
     * The method checks for a valid ID and prevents reducing the age.
     */
    private void updateStaff() {
        String name, gender = null, id;
        int age;
        Scanner scan = new Scanner(System.in);
        InputID inputID = new InputID();
        id = inputID.getStringInput();

        for (User staff : staffList) {
            if (staff.getUserId().equals(id)) {
                System.out.println("Update name: ");
                name = scan.next();

                DisplayGender.display();
                int choiceGen = inputGenderChoice.getIntChoice();
                switch (choiceGen) {
                    case 1:
                        gender = "Male";
                        break;
                    case 2:
                        gender = "Female";
                        break;
                    case 3:
                        gender = "Prefer not to say";
                        break;
                    default:
                        System.out.println("Invalid gender choice");
                }

                while (true) {
                    System.out.println("Update age: ");
                    age = scan.nextInt();
                    if (age < staff.getAge()) {
                        System.out.println("You can't turn back your age!");
                    } else {
                        break;
                    }
                }

                staff.setName(name);
                staff.setGender(gender);
                staff.setAge(age);
                return;
            }
        }
        System.out.println("Invalid Staff ID\n");
    }

    /**
     * Removes a staff member from the staff list based on their ID.
     * Displays an error if the staff member is not found.
     */
    private void removeStaff() {
        String id;
        InputID inputID = new InputID();
        id = inputID.getStringInput();

        for (User staff : staffList) {
            if (staff.getUserId().equals(id)) {
                staffList.remove(staff);
                return;
            }
        }
        System.out.println("Staff not found\n");
    }

    /**
       Displays details of all staff members using the StaffDisplay view.
     */
    private void displayStaff() {
        StaffDisplay.display(staffList);
    }
}
