package system;
import model.Administrator;
import model.User;

/**
 *  Not used. See StaffParser
 */

public class AdministratorParser implements CSVReader.CSVParser<User> {
    @Override
    public Administrator parse(String line) {
        String[] data = line.split(",");
        String id = data[0];
        String name = data[1];
        String gender = data[3];
        int age = Integer.parseInt(data[4]);

        return new Administrator(id, name, age, gender);
    }
}
