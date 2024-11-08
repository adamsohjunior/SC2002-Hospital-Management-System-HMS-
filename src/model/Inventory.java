package model;
public class Inventory {
	private String medicineName, status;
	private int stockAvailable, alertLevel;

	public Inventory(String name, int stockAvailable, int alertLevel) {
		this.medicineName = name;
		this.stockAvailable = stockAvailable;
        this.alertLevel = alertLevel;
        this.status = "sufficient";  // 3 possible status: sufficient, low, pending
	}
	
	public boolean updateStock() {
        if (stockAvailable <= 0){
            System.out.println("Stock not available, re-stock required!");
            return false;
        }else{
            stockAvailable = stockAvailable - 1;
            System.out.println("Prescribed. Stocks Remaining: " + stockAvailable);
            this.lowStockAlert();
            return true;
        }
	}

    private void lowStockAlert(){
        if (this.getStock() <= alertLevel){
            System.out.println(medicineName + " is in under low stock level alert.");
            this.status = "low";
        };
    }
	
	public String getName() {
		return this.medicineName;
	}
	public int getStock() {
		return stockAvailable;
	}

    public String getStatus() {
		return status;
	}

    public void setStatus(String status) {
        this.status = status;
    }

	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Stock Available: " + stockAvailable);
        System.out.println("Stock Status: " + status);
	}
	
}