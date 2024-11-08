package system;
import java.time.Year;
import java.util.ArrayList;

import model.Appointment;
import model.Available;
import model.Patient;

public class PatientParser implements CSVReader.CSVParser<Patient> {
    private Available availableDates;
    private ArrayList<Appointment> allAppointments;
    
    public PatientParser(Available availableDates, ArrayList<Appointment> allAppointments) {
        this.availableDates = availableDates;
        this.allAppointments = allAppointments;
    }

    public Patient parse(String line) {
        String[] data = line.split(",");
        String id = data[0];
        String name = data[1];
        String dob = data[2];
        String gender = data[3];
        String bloodType = data[4];
        String email = data[5];

        int currentYear = Year.now().getValue();
        int birthYear = Integer.parseInt(dob.substring(0, 4));
        int age = currentYear - birthYear;

        return new Patient(id, name, age, email, bloodType, dob, availableDates, gender, allAppointments);
    }
}