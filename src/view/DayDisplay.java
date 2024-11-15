package view;

public class DayDisplay implements DisplayInfo{
	static public void display() {
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Select Day			   ");
		System.out.println(border);
		System.out.println("Please select a number 1-31: ");
		System.out.println(border);
		System.out.println("");
	}
}
