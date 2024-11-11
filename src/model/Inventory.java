package model;

public class Inventory {

    public enum RequestStatus {
        NULL,
        PENDING,
        APPROVED
    }

    public enum Status {
        SUFFICIENT,
        LOW
    }

	private String medicineName;
	private int stockAvailable, alertLevel;
    private Status status;
    private RequestStatus reqStatus;

	public Inventory(String name, int stockAvailable, int alertLevel) {
		this.medicineName = name;
		this.stockAvailable = stockAvailable;
        this.alertLevel = alertLevel;
        this.status = Status.SUFFICIENT;  // 2 possible status: sufficient, low
        this.reqStatus = RequestStatus.NULL; // null, pending, approved
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
            this.status = Status.LOW;
        };
    }
	
	public String getName() {
		return this.medicineName;
	}
	public int getStock() {
		return stockAvailable;
	}

    public void setStock(int newStock) {
        this.stockAvailable = newStock;
    }

    public Status getStatus() {
		return status;
	}

    public RequestStatus getreqStatus() {
		return reqStatus;
	}

    public int getAlertLevel() {
        return this.alertLevel;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setreqStatus(RequestStatus reqStatus) {
        this.reqStatus = reqStatus;
    }

    public void setAlertLevel(int alertLevel) {
        this.alertLevel = alertLevel;
    }

	public void display(){
		System.out.println("Medicine Name: " +  medicineName);
		System.out.println("Stock Available: " + stockAvailable);
        System.out.println("Stock Status: " + status);
        System.out.println("Replenishment Request Status: " + reqStatus);
	}
	
}