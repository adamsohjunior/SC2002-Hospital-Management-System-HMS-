package system;

import java.util.ArrayList;

import model.Appointment;
import model.AppointmentOutcomeRecord;
import model.Available;
import model.Inventory;
import model.Patient;
import model.User;

import view.DisplayLog;

// Facade pattern
public class SystemManager {
    // Global (system) variables
    private SessionManager sessionManager;
    private ArrayList<Inventory> storage;
    private ArrayList<User> staffList;      // for admin usage
    private Available availableDates;
    private ArrayList<Appointment> allAppointments;
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;

    // Flag for system shutdown
    private boolean shutdown;

    // Main user list for sessionManagement
    private ArrayList<User> users;
    
    // Paths for file I/O
    private final String medicineListPath = "../data/Medicine_List.csv";
    private final String patientListPath = "../data/Patient_List.csv";
    private final String staffListPath = "../data/Staff_List.csv";


    public void initialise() {
        DisplayLog.display("System starting...");
        this.storage = new ArrayList<Inventory>();
        this.staffList = new ArrayList<User>();
        this.users = new ArrayList<User>();
        this.availableDates = new Available();
        this.allAppointments = new ArrayList<Appointment>();
        this.allAppointmentOutcomeRecords = new ArrayList<AppointmentOutcomeRecord>();
        this.sessionManager = new SessionManager(users);
        this.shutdown = false;
    }

    public void loadData() {
        // Load inventory items
        InventoryParser inventoryParser = new InventoryParser();
        PatientParser patientParser = new PatientParser(availableDates, allAppointments);
        StaffParser staffParser = new StaffParser(availableDates, allAppointmentOutcomeRecords, storage, allAppointments, this, staffList);

        DisplayLog.display("Loading data from CSV files...");
        //storage = new CSVReader<Inventory>().read(medicineListPath, inventoryParser);
        users.addAll(new CSVReader<Patient>().read(patientListPath, patientParser));    // No need for patientList
        staffList.addAll(new CSVReader<User>().read(staffListPath, staffParser));
        users.addAll(staffList);
        storage.addAll(new CSVReader<Inventory>().read(medicineListPath,inventoryParser));
    }

    public void runSystem() {
        while (true) {
            DisplayLog.display("Welcome to HMS!");
            sessionManager.startNewSession();
            if (shutdown) {
                return;
            }
        }
    }

    public void shutdown() {
        shutdown = true;
    }

    public ArrayList<Inventory> getStorage() {
        return this.storage;
    }

    public ArrayList<User> getStaffList() {
        return this.staffList;
    }

    public Available getAvailableDates() {
        return this.availableDates;
    }

    public ArrayList<Appointment> getAllAppointments() {
        return this.allAppointments;
    }

    public ArrayList<AppointmentOutcomeRecord> getAllAppointmentOutcomeRecords() {
        return this.allAppointmentOutcomeRecords;
    }
}
