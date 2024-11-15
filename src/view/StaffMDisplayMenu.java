package view;

public class StaffMDisplayMenu implements DisplayMenu{
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Staff Menu			   ");
		System.out.println(border);
        System.out.println("1) Add Staff\r\n"
		    					+ "2) Update Staff\r\n"
		    					+ "3) Remove Staff\r\n"
		    					+ "4) Display Staff\r\n"
		    					+ "5) Exit\r");
        System.out.println(border);
        System.out.println("");
    } 
}
