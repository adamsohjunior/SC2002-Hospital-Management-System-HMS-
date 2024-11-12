package view;

import model.Prescription;

public class PrescriptionDisplay {

    static public void display(Prescription medicine) {
		System.out.println("");
		System.out.println("Medicine Name: " +  medicine.getName());
		System.out.println("Medicine Status: " + medicine.getStatus());
		System.out.println("");
    }
}

