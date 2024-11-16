package system;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Inventory;
import model.MedicalRecord;
import model.Patient;
import model.User;

/**
 * the CSVWriter is the function to write data into csv file
 */
public class CSVWriter {
    private String userHeader = "Staff ID,Name,Role,Gender,Age";
    private String patientHeader = "Patient ID,Name,Date of Birth,Gender,Blood Type,Contact Information";
    private String medicineHeader = "Medicine Name,Initial Stock,Low Stock Level Alert";
    private String StaffFilePath = "../data/Staff_List.csv";
    private String PatientFilePath = "../data/Patient_List.csv";
    private String MedicineFilePath = "../data/Medicine_List.csv";
    private ArrayList<User> staffList; 
    private ArrayList<User> patientList; 
    private ArrayList<Inventory> allInventoryItem;

    /**
     * Constructs CSVWriter object with the given details
     * 
     * @param staffList        the list of staff members
     * @param patientList      the list of patients
     * @param allInventoryItem the list of all Inventories
     */
    public CSVWriter(ArrayList<User> staffList, ArrayList<User> patientList, ArrayList<Inventory> allInventoryItem) {
        this.staffList = staffList;
        this.patientList = patientList;
        this.allInventoryItem = allInventoryItem;
    }

    /**
     * method to write staff's detail back into Staff_List.csv once system is shut down
     * 
     * @param staffList    the list of all patients
     * @throws IOException if an error occurs while writing to the file 
     */
    private void writeUser(ArrayList<User> staffList) throws IOException  {
        // error checking
        if (staffList == null || staffList.isEmpty()) {
            throw new IllegalArgumentException("The data list is empty or null.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(StaffFilePath))) {
            // write the header of CSV
            writer.write(userHeader);
            writer.newLine();   
            
            for (User user : staffList) {
                // define role
                char uid = user.getUserId().charAt(0);
                String role;
                switch (uid){
                    case 'D':
                        role = "Doctor";
                        break;
                    case 'P':
                        role = "Pharmacist";
                        break;
                    case 'A':
                        role = "Administrator";
                        break;
                    default:
                        role = null;
                        break;
                }

                // write values in order of userHeader
                writer.write(user.getUserId());
                writer.write(",");
                writer.write(user.getName());
                writer.write(",");
                writer.write(role);
                writer.write(",");
                writer.write(user.getGender());
                writer.write(",");

                String age = String.valueOf(user.getAge());
                writer.write(age);

                writer.newLine();
            }
        }catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * method to write patient's data back into Patient_List.csv once system is shut down
     * 
     * @param patientList  the list of all patients
     * @throws IOException if an error occurs while writing to the file
     */
    private void writePatient(ArrayList<User> patientList) throws IOException  {
        // error checking
        if (patientList == null || patientList.isEmpty()) {
            throw new IllegalArgumentException("The data list is empty or null.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PatientFilePath))) {
            // write the header of CSV
            writer.write(patientHeader);
            writer.newLine();   
            
            for (User user : patientList) {
                // get patient's detail through medical record
                Patient patient = (Patient) user; // downcasting, safe since patientList contains Patient object only
                MedicalRecord medicalRecord = patient.getMedicalRecord();

                // write values in order of userHeader
                writer.write(medicalRecord.getUserId() != null ? medicalRecord.getUserId() : "");
                writer.write(",");
                writer.write(medicalRecord.getName() != null ? medicalRecord.getName() : "");
                writer.write(",");
                writer.write(medicalRecord.getDateOfBirth() != null ? medicalRecord.getDateOfBirth() : "");
                writer.write(",");
                writer.write(medicalRecord.getGender() != null ? medicalRecord.getGender() : "");
                writer.write(",");
                writer.write(medicalRecord.getBloodType() != null ? medicalRecord.getBloodType() : "");
                writer.write(",");
                writer.write(medicalRecord.getEmail() != null ? medicalRecord.getEmail() : "");            

                writer.newLine();
            }
        }catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * method write medicine data back into Medicine_List.csv once system is shut down
     * 
     * @param allInventoryItems the list of all Inventories
     * @throws IOException      if an error occurs while writing to the file
     * 
     */
    private void writeMedicine(ArrayList<Inventory> allInventoryItems) throws IOException  {
        // error checking
        if (allInventoryItems == null || allInventoryItems.isEmpty()) {
            throw new IllegalArgumentException("The data list is empty or null.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MedicineFilePath))) {
            // write the header of CSV
            writer.write(medicineHeader);
            writer.newLine();   
            
            for (Inventory stock : allInventoryItems) {
                // write values in order of userHeader
                writer.write(stock.getName() != null ? stock.getName() : "");
                writer.write(",");

                String availableStock = String.valueOf(stock.getStock());
                writer.write(availableStock);
                writer.write(",");

                String alertLevel = String.valueOf(stock.getAlertLevel());
                writer.write(alertLevel);
               
                writer.newLine();
            }
        }catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * method to call writeUser(), writePatien() and writeMedicine()
     */
    public void writeData() {
        try {
            writeUser(staffList);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage() );
        }
        try {
            writePatient(patientList);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage() );
        }
        try {
            writeMedicine(allInventoryItem);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage() );
        }
    }

}
              