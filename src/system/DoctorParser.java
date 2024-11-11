package system;
import java.util.ArrayList;

import model.AppointmentOutcomeRecord;
import model.Available;
import model.Doctor;
import model.Inventory;

/*
 *  Not used. See StaffParser
 */

public class DoctorParser implements CSVReader.CSVParser<Doctor> {
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private Available availableDates;
    private ArrayList<Inventory> storage;

    public DoctorParser(Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage) {
        this.availableDates = availableDates;
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.storage = storage;
    }
    
    @Override
    public Doctor parse(String line) {
        String[] data = line.split(",");
        String id = data[0];
        String name = data[1];
        String gender = data[3];
        int age = Integer.parseInt(data[4]);

        return new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage);
    }
}