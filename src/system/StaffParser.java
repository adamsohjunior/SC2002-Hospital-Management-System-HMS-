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

public class StaffParser implements CSVReader.CSVParser<User> {
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private Available availableDates;
    private ArrayList<Inventory> storage;
    private ArrayList<User> staffList;
    private ArrayList<Appointment> allAppointments;

    public StaffParser(Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage, ArrayList<User> staffList, ArrayList<Appointment> allAppointments) {
        this.availableDates = availableDates;
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.storage = storage;
        this.staffList = staffList;
        this.allAppointments = allAppointments;
    }
    
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
                return new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage);
            case "Administrator":
                return new Administrator(id, name, age, gender, storage, staffList, allAppointments);
            default:
                throw new IllegalArgumentException("Invalid user role!");
        }
    }
}