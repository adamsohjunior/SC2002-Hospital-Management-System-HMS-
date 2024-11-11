package view;

public class StaffDisplayMenu implements DisplayMenu{
    public static void display() {
        System.out.println("");
		System.out.println("==============================================");
        System.out.println("Select the Staff's Role"
                        + "1) Doctor\r\n"
                        + "2) Pharmacist\r\n"
                        + "3) Admin\r\n"
                        + "4) Exit\r\n");
        System.out.println("==============================================");
        System.out.println("");
    }
}
