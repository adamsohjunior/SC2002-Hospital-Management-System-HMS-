import java.util.HashMap;

public class Inventory {
    HashMap<String, Stock> inventory = new HashMap<>();

    public void add(String name, Stock stockInfo) {
        inventory.put(name, stockInfo);
    }

    public void addStock() {
        
    }
}
