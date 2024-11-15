package system;

import java.util.ArrayList;

import model.Appointment;
import model.AppointmentOutcomeRecord;
import model.Available;
import model.Inventory;
import model.Patient;
import model.User;

import view.DisplayLog;

import system.Writer;

/**
 * SystemManager class that handle the operation of system
 */
// Facade pattern
public class SystemManager {
    /** Global (system) variables */ 
    private SessionManager sessionManager;
    private ArrayList<Inventory> storage;
    private ArrayList<User> staffList;      // for admin usage
    private ArrayList<User> patientList;
    private Available availableDates;
    private ArrayList<Appointment> allAppointments;
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;

    /** Flag for system shutdown */ 
    private boolean shutdown;

    /** Main user list for sessionManagement */ 
    private ArrayList<User> users;
    
    /** Paths for file I/O */ 
    private final String medicineListPath = "../data/Medicine_List.csv";
    private final String patientListPath = "../data/Patient_List.csv";
    private final String staffListPath = "../data/Staff_List.csv";

    /**
     * method to initialise the variable needed
     */
    public void initialise() {
        DisplayLog.display("\nSystem starting...");
        this.storage = new ArrayList<Inventory>();
        this.staffList = new ArrayList<User>();
        this.patientList = new ArrayList<User>();
        this.users = new ArrayList<User>();
        this.availableDates = new Available();
        this.allAppointments = new ArrayList<Appointment>();
        this.allAppointmentOutcomeRecords = new ArrayList<AppointmentOutcomeRecord>();
        this.sessionManager = new SessionManager(users);
        this.shutdown = false;
    }

    /**
     * method to load all the necessary data into the system
     */
    public void loadData() {
        // Load inventory items
        InventoryParser inventoryParser = new InventoryParser();
        PatientParser patientParser = new PatientParser(availableDates, allAppointments);
        StaffParser staffParser = new StaffParser(availableDates, allAppointmentOutcomeRecords, storage, allAppointments, this, staffList);

        DisplayLog.display("Loading data from CSV files...");
        storage.addAll(new CSVReader<Inventory>().read(medicineListPath,inventoryParser));
        patientList.addAll(new CSVReader<Patient>().read(patientListPath, patientParser));
        staffList.addAll(new CSVReader<User>().read(staffListPath, staffParser));
        users.addAll(patientList);
        users.addAll(staffList);
    }

    /**
     * method to run HMS system by starting a new session
     */
    public void runSystem() {
        while (true) {
            
            System.out.println();
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                           __    __    ______________      ______                             SC2002 ║");
            System.out.println("║                          /  |  /  |  /              \\    /      \\                              SCS6 ║");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐▐▐▐▐▐▐▐▐▐▐▐▐  |  /▐▐▐▐▐▐▐ |                           TEAM 5 ║");
            System.out.println("║                          ▐▐ |__▐▐ |  ▐▐  _ ▐▐  _ ▐▐  |  ▐▐ \\__▐▐/                                   ║");
            System.out.println("║                          ▐▐    ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |  ▐▐      \\                                   ║");
            System.out.println("║                          ▐▐▐▐▐▐▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |   ▐▐▐▐▐▐▐ |                                  ║");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |   / \\__ ▐▐|                                  ║ ");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |  ▐▐    ▐▐▐|                                  ║");
            System.out.println("║                          ▐▐/   ▐▐/   ▐▐/   ▐▐/   ▐▐ /    ▐▐▐▐▐▐▐/                                   ║");
            System.out.println("║                                                                                                     ║");
            System.out.println("║                           Welcome to Hospital Management System                                     ║");
            System.out.println("║                                                                                                     ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("");
            
            sessionManager.startNewSession();
            if (shutdown) {
                return;
            }
        }
    }

    /**
     * method to save every modified into the original CSV
     */
    public void saveData() {
        Writer csvwriter = new Writer(staffList, patientList, storage);
        csvwriter.writeDataIntoCSV();
    }

    /**
     * method to shut down the system
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * method to add user into user list
     * 
     * @param user user that is interacting with the system
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * method to retrive Inventory List
     * 
     * @return the list with all Inventory object
     */
    public ArrayList<Inventory> getStorage() {
        return this.storage;
    }

    /**
     * method to retrieve Staff List
     * 
     * @return the list with all Staff object
     */
    public ArrayList<User> getStaffList() {
        return this.staffList;
    }

    /**
     * method to get the available dates
     * 
     * @return available dates of Doctor
     */
    public Available getAvailableDates() {
        return this.availableDates;
    }

    /**
     * method to get all appointments
     * 
     * @return the list of all Appointment object
     */
    public ArrayList<Appointment> getAllAppointments() {
        return this.allAppointments;
    }

    /**
     * method to get all Appointment Outcome Records
     * 
     * @return the list of all AppointmentOutcomeRecord object
     */
    public ArrayList<AppointmentOutcomeRecord> getAllAppointmentOutcomeRecords() {
        return this.allAppointmentOutcomeRecords;
    }
}
