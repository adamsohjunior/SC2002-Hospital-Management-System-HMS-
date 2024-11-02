public class MedicineParser implements CSVReader.CSVParser<Stock> {
    public Stock parse(String line) {
        String[] data = line.split(",");
        String name = data[0];
        int amount = Integer.parseInt(data[1]);
        int alertThreshold = Integer.parseInt(data[2]);

        return new Stock(amount, alertThreshold);
    }
}