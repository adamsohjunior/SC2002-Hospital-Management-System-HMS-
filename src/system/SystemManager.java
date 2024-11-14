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

// Facade pattern
public class SystemManager {
    // Global (system) variables
    private SessionManager sessionManager;
    private ArrayList<Inventory> storage;
    private ArrayList<User> staffList;      // for admin usage
    private ArrayList<User> patientList;
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
        this.patientList = new ArrayList<User>();
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
        storage.addAll(new CSVReader<Inventory>().read(medicineListPath,inventoryParser));
        patientList.addAll(new CSVReader<Patient>().read(patientListPath, patientParser));
        staffList.addAll(new CSVReader<User>().read(staffListPath, staffParser));
        users.addAll(patientList);
        users.addAll(staffList);
    }

    public void runSystem() {
        while (true) {
            
            System.out.println();
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                           __    __    ______________      ______                                    ║");
            System.out.println("║                          /  |  /  |  /              \\    /      \\                                   ║");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐▐▐▐▐▐▐▐▐▐▐▐▐  |  /▐▐▐▐▐▐▐ |                                  ║");
            System.out.println("║                          ▐▐ |__▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |  ▐▐ \\__▐▐/                                   ║");
            System.out.println("║                          ▐▐    ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |  ▐▐      \\                                   ║");
            System.out.println("║                          ▐▐▐▐▐▐▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |   ▐▐▐▐▐▐▐ |                                  ║");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |   / \\__ ▐▐|                                  ║ ");
            System.out.println("║                          ▐▐ |  ▐▐ |  ▐▐ |  ▐▐ |  ▐▐  |  ▐▐    ▐▐▐|                                  ║");
            System.out.println("║                          ▐▐/   ▐▐/   ▐▐/   ▐▐/   ▐▐ /    ▐▐▐▐▐▐▐/                                   ║");
            System.out.println("║                                                                                                     ║");
            System.out.println("║                            Welcome to Hospital Management System                                    ║");
            System.out.println("║                                                                                                     ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");

            sessionManager.startNewSession();
            if (shutdown) {
                return;
            }
        }
    }

    public void saveData() {
        Writer csvwriter = new Writer(staffList, patientList, storage);
        csvwriter.writeDataIntoCSV();
    }

    public void shutdown() {
        shutdown = true;
    }

    public void addUser(User user) {
        users.add(user);
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
