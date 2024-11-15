package view;

public class InventoryDisplayMenu implements DisplayMenu {
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Inventory Menu		   ");
		System.out.println(border);
        System.out.println("1) Add Stocks\r\n"
		    					+ "2) Update Stocks\r\n"
		    					+ "3) Remove Stocks\r\n"
		    					+ "4) Update Alert Line\r\n"
		    					+ "5) Approve Replenishment Requests\r\n"
                                + "6) Display Inventory\r\n"
		    					+ "7) Exit\r");
        System.out.println(border);
        System.out.println("");
    }
}
