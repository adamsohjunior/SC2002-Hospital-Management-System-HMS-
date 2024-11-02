import java.util.ArrayList;

public class StaffParser implements CSVReader.CSVParser<User> {
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
                return new Doctor(id, name, age, gender, new Available(), new ArrayList<>());
            case "Pharmacist":
                return new Pharmacist(id, name, age, gender);
            case "Administrator":
                return new Administrator(id, name, age, gender);
            default:
                throw new IllegalArgumentException("Invalid user role!");
        }
    }
}