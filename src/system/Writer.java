package system;

import java.util.ArrayList;
import system.CSVWriter;
import model.Inventory;
import model.User;

// class to handle the writing of data into different file
public class Writer {
    ArrayList<Inventory> allInventoryItem;
    ArrayList<User> staffList; 
    ArrayList<User> patientList;
    
    public Writer(ArrayList<User> staffList, ArrayList<User> patientList, ArrayList<Inventory> allInventoryItem) {
        this.staffList = staffList;        
        this.patientList = patientList;
        this.allInventoryItem = allInventoryItem;
    }

    public void writeDataIntoCSV() {
        CSVWriter csvwriter = new CSVWriter(staffList, patientList, allInventoryItem);
        csvwriter.writeData();         
    }
}
