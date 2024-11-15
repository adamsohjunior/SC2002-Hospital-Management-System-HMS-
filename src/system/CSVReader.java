package system;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.User;
/**
 * CSVReader class to read in CSV data
 */
public class CSVReader<T> {
    /**
     * method to read in respective data
     * 
     * @param filePath path of the CSV file 
     * @param parser   an object to parse
     * @return         arraylist of different data
     */
    public ArrayList<T> read(String filePath, CSVParser<T> parser) {
        ArrayList<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                T item = parser.parse(line);
                list.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * Interface to create a parser object to read CSV file
     */
    public interface CSVParser<T> {
        T parse(String line);
    }
}
