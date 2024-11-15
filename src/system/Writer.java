package system;

import java.util.ArrayList;
import model.Inventory;
import model.User;

/**
 * class to handle the writing of data into different file
 */
public class Writer {
    ArrayList<Inventory> allInventoryItem;
    ArrayList<User> staffList; 
    ArrayList<User> patientList;

    /**
     * Constructs an Writer object with the given details
     * 
     * @param staffList         the list of staff members
     * @param patientList       the list of all patients
     * @param allInventoryItem  the list of all Inventories
     */
    public Writer(ArrayList<User> staffList, ArrayList<User> patientList, ArrayList<Inventory> allInventoryItem) {
        this.staffList = staffList;        
        this.patientList = patientList;
        this.allInventoryItem = allInventoryItem;
    }

    /**
     * method to handle the writing of data into CSV
     */
    public void writeDataIntoCSV() {
        CSVWriter csvwriter = new CSVWriter(staffList, patientList, allInventoryItem);
        csvwriter.writeData();         
    }
}
