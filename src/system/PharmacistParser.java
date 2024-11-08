package system;
import java.util.ArrayList;

import model.AppointmentOutcomeRecord;
import model.Available;
import model.Inventory;
import model.Pharmacist;
import model.User;

public class PharmacistParser implements CSVReader.CSVParser<User> {
    private ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords;
    private Available availableDates;
    private ArrayList<Inventory> storage;

    public PharmacistParser(Available availableDates, ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords, ArrayList<Inventory> storage) {
        this.availableDates = availableDates;
        this.allAppointmentOutcomeRecords = allAppointmentOutcomeRecords;
        this.storage = storage;
    }
    
    @Override
    public User parse(String line) {
        String[] data = line.split(",");
        String id = data[0];
        String name = data[1];
        String gender = data[3];
        int age = Integer.parseInt(data[4]);

        return new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage);
    }
}