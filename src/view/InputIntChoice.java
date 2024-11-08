package view;

import java.util.InputMismatchException;

public class InputIntChoice implements InputInt{
	private int numberOfChoice;
	
	
	public InputIntChoice(int no) {
		numberOfChoice = no;
	}
	
	public int getIntChoice() {
		
		  int choice =-1;
		  boolean validity = false;
	      while (!validity) { 
	            try {
	            	System.out.println("Please input a choice: ");
	                choice = scan.nextInt(); 
	                if(choice>0 && choice<=numberOfChoice) {
	                
	 
	                	validity = true;
	             
	                	
	                }
	                else {
	                	System.out.println("Please input a choice that is valid.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter an appropriate choice.");
	                scan.next(); 
	            }
	        }
			/* clear the enter key */
			scan.nextLine();
			return choice;
	}
}
