import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader<T> {
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

    public interface CSVParser<T> {
        T parse(String line);
    }
}
