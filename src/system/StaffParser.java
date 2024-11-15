package system;
import java.util.ArrayList;

import model.Administrator;
import model.AppointmentOutcomeRecord;
import model.Available;
import model.Doctor;
import model.Inventory;
import model.Pharmacist;
import model.User;
import model.Appointment;

/**
 * StaffParser class for parsing
 */
public class StaffParser implements CSVReader.CSVParser<User> {
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private Available availableDates;
    private ArrayList<Inventory> storage;
    private ArrayList<User> staffList;
    private ArrayList<Appointment> allAppointments;
    private SystemManager systemManager;

    /**
     * constructs StaffParser object with the given details
     * 
     * @param availableDates               the available dates
     * @param allAppointmentOutcomeRecords the list of all Appointment Outcome Records
     * @param storage                      the list of all Inventories
     * @param allAppointments              the list of all Appointments
     * @param systemManager                the entity that manage the  entire system
     * @param staffList                    the list of all staffs
     */
    public StaffParser(Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage, ArrayList<Appointment> allAppointments, SystemManager systemManager, ArrayList<User> staffList) {
        this.availableDates = availableDates;
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.storage = storage;
        this.allAppointments = allAppointments;
        this.systemManager = systemManager;
        this.staffList = staffList;
    }
    
    /**
     * method to extract a line of information from CSV and construct an User object
     */
    @Override
    public User parse(String line) {
        String[] data = line.split(",");
        String id = data[0];
        String name = data[1];
        String role = data[2];
        String gender = data[3];
        int age = Integer.parseInt(data[4]);

        switch (role) {
            case "Doctor":
                return new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage);
            case "Pharmacist":
                return new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage, staffList);
            case "Administrator":
                return new Administrator(id, name, age, gender, storage, staffList, allAppointments, systemManager);
            default:
                throw new IllegalArgumentException("Invalid user role!");
        }
    }
}