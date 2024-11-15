package view;

public class MonthDisplay implements DisplayInfo{
	static public void display() {
		String border = "----------------------------------------------";
		System.out.println("");
		System.out.printf("%-44s\n", "		Select Month			   ");
		System.out.println(border);
		System.out.println("Please select a Month: ");
		System.out.println("1) Jan");
		System.out.println("2) Feb");
		System.out.println("3) Mar");
		System.out.println("4) Apr");
		System.out.println("5) May");
		System.out.println("6) Jun");
		System.out.println("7) Jul");
		System.out.println("8) Aug");
		System.out.println("9) Sep");
		System.out.println("10) Oct");
		System.out.println("11) Nov");
		System.out.println("12) Dec");
		System.out.println(border);
		System.out.println("");
	}
}

	
