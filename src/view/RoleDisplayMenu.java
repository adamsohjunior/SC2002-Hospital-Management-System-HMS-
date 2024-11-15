package view;

public class RoleDisplayMenu implements DisplayMenu{
    public static void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Role Menu			   ");
		System.out.println(border);
        System.out.println("Select the Staff's Role\r\n"
                        + "1) Doctor\r\n"
                        + "2) Pharmacist\r\n"
                        + "3) Admin\r");
        System.out.println(border);
        System.out.println("");
    }
}
