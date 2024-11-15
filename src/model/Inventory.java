package model;
/**
 * Represents the inventory for a specific medicine in a hospital management system.
 * Includes details about stock availability, alert levels, stock status, 
 * and replenishment request status.
 * 
 */
public class Inventory {

    /**
     * Enum representing the status of a replenishment request.
     */

    public enum RequestStatus {
        NULL,
        PENDING,
        APPROVED
    }

    /**
     * Enum representing the stock status of a medicine.
     */

    public enum Status {
        SUFFICIENT,
        LOW
    }

    /**
     * @param medicineName   the name of medicine
     * @param stockAvailable the remaining quantity of stock
     * @param alertLevel     the low alert level indicator of stock
     * @param status         the availability status of stock 
     * @param reqStatus      the replenishment request status of stock
     */

	private String medicineName;
	private int stockAvailable, alertLevel;
    private Status status;
    private RequestStatus reqStatus;

    /**
     * Constructs a new Inventory object for a specific medicine.
     * Initializes the stock status as 'SUFFICIENT' and the
     * request status as 'NULL'.
     * 
     * @param name the name of the medicine.
     * @param stockAvailable the initial stock available.
     * @param alertLevel the stock level at which alerts should be triggered.
     */

	public Inventory(String name, int stockAvailable, int alertLevel) {
		this.medicineName = name;
		this.stockAvailable = stockAvailable;
        this.alertLevel = alertLevel;
        this.status = Status.SUFFICIENT;  // 2 possible status: sufficient, low
        this.reqStatus = RequestStatus.NULL; // null, pending, approved
	}
	
     /**
     * Updates the stock by reducing it by one unit if available.
     * Triggers a low stock alert if the stock reaches the alert level.
     * 
     * @return true if the stock was successfully updated; false if the stock is unavailable.
     */

	public boolean updateStock() {
        if (stockAvailable <= 0){
            System.out.println("Stock not available, re-stock required!");
            return false;
        }else{
            stockAvailable = stockAvailable - 1;
            System.out.println(medicineName + " Prescribed. Stocks Remaining: " + stockAvailable);
            this.lowStockAlert();
            return true;
        }
	}

     /**
     * Checks if the stock has reached or dropped below the alert level.
     * Updates the status to 'LOW' and prints a low stock alert if applicable.
     */

    private void lowStockAlert(){
        if (this.getStock() <= alertLevel){
            System.out.println(medicineName + " is in under low stock level alert.");
            this.status = Status.LOW;
        };
    }
	
    /**
     * Retrieves the name of the medicine.
     * 
     * @return the medicine name.
     */

	public String getName() {
		return this.medicineName;
	}

    /**
     * Retrieves the current stock available for the medicine.
     * 
     * @return the current stock available.
     */

	public int getStock() {
		return stockAvailable;
	}

    /**
     * Updates the stock available for the medicine.
     * 
     * @param newStock the new stock level to set.
     */

    public void setStock(int newStock) {
        this.stockAvailable = newStock;
    }

    /**
     * Retrieves the current stock status of the medicine.
     * 
     * @return the current stock status.
     */

    public Status getStatus() {
		return status;
	}

    /**
     * Retrieves the current replenishment request status.
     * 
     * @return the current request status.
     */

    public RequestStatus getreqStatus() {
		return reqStatus;
	}

    /**
     * Retrieves the alert level for low stock.
     * 
     * @return the low stock alert level.
     */

    public int getAlertLevel() {
        return this.alertLevel;
    }

    /**
     * Sets the current stock status of the medicine.
     * 
     * @param status the new stock status to set.
     */

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets the current replenishment request status.
     * 
     * @param reqStatus the new request status to set.
     */

    public void setreqStatus(RequestStatus reqStatus) {
        this.reqStatus = reqStatus;
    }

    /**
     * Sets a new alert level for low stock.
     * 
     * @param alertLevel the new alert level to set.
     */

    public void setAlertLevel(int alertLevel) {
        this.alertLevel = alertLevel;
    }

    /**
     * Displays the details of the inventory, including the medicine name,
     * stock available, stock status, and replenishment request status.
     */
    
	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Stock Available: " + stockAvailable);
        System.out.println("Stock Status: " + status);
        System.out.println("Replenishment Request Status: " + reqStatus);
	}
	
}