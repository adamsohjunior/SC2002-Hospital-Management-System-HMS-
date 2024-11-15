package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import view.AvailableDatesDisplay;
import view.DisplayLog;
import view.DisplayPrompt;

/**
 * The Available class manages the available appointment slots for doctors and provides functionality
 * for viewing, selecting, updating, and adding available appointment slots.
 */
public class Available {
	private ArrayList<Availability> availableDates = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);

	/**
	 * Displays the available appointment slots and returns the count of available slots.
	 * If no slots are available, it returns -1.
	 *
	 * @return the count of available slots, or -1 if no slots are available
	 */
	public int viewAvailableAppointmentSlots() {
		if (this.availableDates.size() == 0) {
			DisplayLog.display("No available dates for appointments.\n");
			return -1;
		}
		int count = 0;
		for (int i = 0; i < availableDates.size(); i++) {
			if (availableDates.get(i).getStatus().equals("Available")) {
				count++;
			}
		}
		if (count == 0) {
			DisplayLog.display("No available dates for appointments.\n");
			return -1;
		}

		// Displays all available appointment slots.
		AvailableDatesDisplay.display(availableDates);
		return count;
	}

	/**
	 * Allows a patient to select an available appointment slot.
	 * It checks for conflicts with already scheduled appointments before confirming the selection.
	 *
	 * @param scheduledAppointments the list of already scheduled appointments
	 * @param patient the patient making the selection
	 * @return the selected appointment if valid, or null if no slot is available
	 */
	public Appointment selectAvailableSlot(ArrayList<Appointment> scheduledAppointments, Patient patient) {
		int choice = 0;
		boolean validity = false;

		int check = this.viewAvailableAppointmentSlots();
		if (check == -1) {
			return null;
		}

		// Ensures that the patient selects a valid available slot without conflicts.
		while (!validity) {
			try {
				DisplayPrompt.display("Please enter your choice: ");
				choice = scan.nextInt();
				DisplayLog.display("");
				if (choice > 0 && choice <= availableDates.size()) {
					// Check if the selected appointment is valid (no conflict with other appointments)
					String date = this.availableDates.get(choice - 1).getDate();
					String time = this.availableDates.get(choice - 1).getTime();

					validity = true;

					for (int i = 0; i < scheduledAppointments.size(); i++) {
						if (!scheduledAppointments.get(i).getStatus().equals("Rejected")) {
							String checkDate = scheduledAppointments.get(i).getDate();
							String checkTime = scheduledAppointments.get(i).getTime();
							if (date.equals(checkDate) && time.equals(checkTime)) {
								DisplayLog.display("Conflicting date and time with an already scheduled appointment!\n");
								validity = false;
								break;
							}
						}
					}
				} else {
					DisplayLog.display("Please input a choice that is valid.\n");
				}
			} catch (InputMismatchException e) {
				DisplayLog.display("Invalid input! Please enter an appropriate choice.\n");
				scan.next();
			}
		}

		// Clears the enter key
		scan.nextLine();

		choice = choice - 1;
		this.availableDates.get(choice).setStatus("Booked");

		// Creates the appointment object based on the selected slot.
		Appointment appointment = new Appointment(this.availableDates.get(choice).getDoctor(),
				this.availableDates.get(choice).getDate(),
				this.availableDates.get(choice).getTime(),
				patient);
		this.availableDates.get(choice).getDoctor().incomingAppointment(appointment);
		return appointment;
	}

	/**
	 * Updates the availability status of a specific doctor's appointment date/time to "Available".
	 *
	 * @param doc the doctor whose availability is being updated
	 * @param dat the date of the appointment to update
	 * @param tim the time of the appointment to update
	 */
	public void updateAvailableDates(Doctor doc, String dat, String tim) {
		for (int i = 0; i < this.availableDates.size(); i++) {
			if (this.availableDates.get(i).getStatus().equals("Booked")) {
				Availability currentDate = this.availableDates.get(i);
				if (currentDate.getDoctor() == doc && currentDate.getDate().equals(dat) && currentDate.getTime().equals(tim)) {
					currentDate.setStatus("Available");
					break;
				}
			}
		}
	}

	/**
	 * Adds a new available date to the list of available dates, ensuring no duplicates exist.
	 *
	 * @param avail the availability object to add
	 */
	public void addAvailableDates(Availability avail) {
		String doc = avail.getDoctor().getName();
		String dat = avail.getDate();
		String tim = avail.getTime();

		// Checks if the date already exists for the same doctor.
		for (int i = 0; i < availableDates.size(); i++) {
			if (availableDates.get(i).getDoctor().getName().equals(doc) &&
					availableDates.get(i).getDate().equals(dat) &&
					availableDates.get(i).getTime().equals(tim)) {
				DisplayLog.display("Date is already available.\n");
				return;
			}
		}

		// Adds the new available date if no duplicates found.
		availableDates.add(avail);
	}
}
