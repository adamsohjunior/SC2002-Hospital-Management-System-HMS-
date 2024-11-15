package view;

import model.Prescription;

/**
 * Provides a utility to display prescription information in a structured format.
 * Implements the DisplayInfo interface to ensure consistency in displaying details.
 * This class is part of the view layer in the hospital management system.
 * 
 */

public class PrescriptionDisplay implements DisplayInfo {

	/**
     * Displays the details of a given Prescription object in a readable format.
     * 
     * @param medicine the prescription object whose details are to be displayed.
     */

    static public void display(Prescription medicine) {
		System.out.println("");
		System.out.println("Medicine Name: " +  medicine.getName());
		System.out.println("Medicine Status: " + medicine.getStatus());
		System.out.println("");
    }
}

