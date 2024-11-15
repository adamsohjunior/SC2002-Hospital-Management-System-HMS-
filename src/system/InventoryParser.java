package system;
import model.Inventory;

/**
 * InventoryParser class for parsing
 */
public class InventoryParser implements CSVReader.CSVParser<Inventory> {
    /**
     * method to extract information from a line of CSV and construct the Inventory object
     */
    public Inventory parse(String line) {
        String[] data = line.split(",");
        String name = data[0];
        int amount = Integer.parseInt(data[1]);
        int alertThreshold = Integer.parseInt(data[2]);

        return new Inventory(name, amount, alertThreshold);
    }
}