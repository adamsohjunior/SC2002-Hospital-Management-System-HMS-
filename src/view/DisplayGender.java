package view;

public class DisplayGender implements DisplayMenu {
    static public void display() {
        String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n","		Gender			   ");
		System.out.println(border);
		System.out.println("1) Male\r\n"
				+ "2) Female\r\n"
				+ "3) Prefer not to say\r");
		System.out.println(border);
    }
}
