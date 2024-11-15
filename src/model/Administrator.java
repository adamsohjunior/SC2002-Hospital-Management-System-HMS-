package model;

import java.util.ArrayList;
import controller.InventoryManagement;
import controller.StaffManagement;
import model.Appointment;
import view.AdminDisplayMenu;
import view.DisplayLog;
import view.InputIntChoice;
import system.SystemManager;
import view.InputInt;

/**
 * The Administrator class represents an administrator user who has control over inventory and staff management.
 * It provides methods to manage staff, view appointments, manage inventory, and approve requests.
 */
public class Administrator extends User {
	private InventoryManagement inventoryManagement;
	private StaffManagement staffManagement;
	private ArrayList<Appointment> allAppointments;
	private InputInt inputIntChoice = new InputIntChoice(7); // 7 input choices
	private SystemManager systemManager;
	private ArrayList<User> staffList;

	/**
	 * Constructs an Administrator object with the given details.
	 *
	 * @param id               the unique ID of the administrator
	 * @param name             the name of the administrator
	 * @param age              the age of the administrator
	 * @param gender           the gender of the administrator
	 * @param allInventoryItems the list of all inventory items
	 * @param staffList        the list of staff members
	 * @param allAppointments  the list of all appointments
	 * @param systemManager    the system manager object to manage the system's operations
	 */
	public Administrator(String id, String name, int age, String gender, ArrayList<Inventory> allInventoryItems, ArrayList<User> staffList, ArrayList<Appointment> allAppointments, SystemManager systemManager) {
		super(id, name, age, gender);
		this.inventoryManagement = new InventoryManagement(allInventoryItems);
		this.staffManagement = new StaffManagement(staffList, allInventoryItems, allAppointments, systemManager);
		this.allAppointments = allAppointments;
		this.systemManager = systemManager;
		this.staffList = staffList;
	}

	/**
	 * Sets the staff list for the administrator.
	 *
	 * @param staffList the new list of staff members
	 */
	public void setStaffList(ArrayList<User> staffList) {
		this.staffList = staffList;
	}

	/**
	 * Manages the inventory by delegating to the InventoryManagement class.
	 */
	public void manageInventory() {
		inventoryManagement.manageInventory();
	}

	/**
	 * Approves a request for inventory by delegating to the InventoryManagement class.
	 */
	public void approveRequest() {
		inventoryManagement.approveRequest();
	}

	/**
	 * Manages the staff by delegating to the StaffManagement class.
	 */
	public void manageStaff() {
		staffManagement.manageStaff();
	}

	/**
	 * Displays the main menu for the administrator and allows interaction
	 * for managing staff, appointments, inventory, requests, and more.
	 */
	public void displayMenu() {
		int choice;
		System.out.println("");
		DisplayLog.display("WELCOME, " + this.getName() + "!");

		do {
			AdminDisplayMenu.display();
			choice = inputIntChoice.getIntChoice();

			switch(choice) {
				case 1:
					manageStaff();
					break;
				case 2:
					viewAppointment(allAppointments);
					break;
				case 3:
					manageInventory();
					break;
				case 4:
					approveRequest();
					break;
				case 5:
					systemManager.shutdown();
					break;
				case 6:
					showInbox();
					break;
				case 7:
					System.out.println("Logged out successfully!\n");
					break;
			}
		} while (choice != 5 && choice != 7);
	}

	/**
	 * Displays appointment details for all appointments.
	 *
	 * @param allAppointments the list of all appointments
	 */
	private void viewAppointment(ArrayList<Appointment> allAppointments) {
		for(Appointment a : allAppointments) {
			System.out.println("");
			a.printInfoForAdmin();
			System.out.println("");
		}
	}
}
