package view;

public class InventoryDisplayMenu implements DisplayMenu {
    public static void display() {
        System.out.println("");
		System.out.println("==============================================");
        System.out.println("1) Add Stocks\r\n"
		    					+ "2) Update Stocks\r\n"
		    					+ "3) Remove Stocks\r\n"
		    					+ "4) Update Alert Line\r\n"
		    					+ "5) Approve Replenishment Requests\r\n"
		    					+ "6) Exit\r\n");
        System.out.println("==============================================");
        System.out.println("");
    }
}
