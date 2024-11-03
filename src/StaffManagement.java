import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StaffManagement {
    public void manageStaff() {
        // Assume I have the staff list
        ArrayList<User> staff;

        int choice=-1;
		boolean validity = false;

        Scanner scan = new Scanner(System.in);
		
		do{
			validity = false;
		      while (!validity) { 
		            try {
		    			System.out.println("What would you like to do?"
                                + "1) Add Staff\r\n"
		    					+ "2) Update Staff Details\r\n"
		    					+ "3) Delete Staff\r\n"
                                + "4) Display Staff\r\n"
		    					+ "5) Exit\r\n");
		                System.out.print("Please enter your choice: ");
		                choice = scan.nextInt(); 
		                if(choice > 0 && choice <= 5) {
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
		        switch(choice) {
		        case 1:
                    addStaff();
                    break;
                case 2:
                    updateStaff();
                    break;
                case 3:
                    removeStaff();
                    break;
                case 4:
                    displayStaff();
		    	    break;
                case 5: 
                    break;
		      }
		} while (choice != 5);
    }

    // add staff
    // Parameter can be (User user), reduce switch case
    public void addStaff() {
        Scanner scan = new Scanner(System.in);

        int choice = -1;
        boolean validity = false;
        while (!validity) { 
            try {
                System.out.println("Select the Staff's Role"
                        + "1) Doctor\r\n"
                        + "2) Pharmacist\r\n"
                        + "3) Admin\r\n"
                        + "4) Exit\r\n");
                System.out.print("Please enter your choice: ");
                choice = scan.nextInt(); 
                if(choice > 0 && choice <= 4) {
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
        if (choice == 4) return;

        String name, gender, id; int age;
        System.out.println("Enter name: ");
        name = scan.next();
        System.out.println("Enter gender: ");
        gender = scan.next();
        System.out.println("Enter age: ");
        age = scan.nextInt();
        scan.next();

        // TODO
        // store data into database
        switch (choice) {           
            case 1: 
                ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords = new ArrayList<>();
                Available availableDates = new Available();
                id = "D" + (int)(doctorList.size() + 1);
                Doctor doctor = new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords);
                doctorList.add(doctor);
                users.add(doctor);
                break;
            case 2: 
                Pharmacist pharmacist = new Pharmacist(id, name, age, gender);
                id = "P" + (int)(pharmacyList.size() + 1);
                pharmacistList.add(pharmacist);
                users.add(pharmacist);
                break;
            case 3:
                Administrator admin = new Administrator(id, name, age, gender);
                id = "A" + (int)(adminList.size() + 1);
                adminList.add(admin);
                users.add(admin);
                break;
            default: 
                System.out.printLn("Invalid Staff Role");
        }      
    }

    //update staff
    public void updateStaff(User user) {
        String name, gender, id; int age;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Staff ID");
        id = scan.next();

        // TODO
        // some ways to check if id is valid...

        System.out.println("Update name: ");
        name = scan.next();
        System.out.println("Update gender: ");
        gender = scan.next();
        System.out.println("Update age: ");
        age = scan.nextInt();
        scan.next();

        user.setName(name);
        user.setGender(gender);
        user.setAge(age);

        // TODO
        // Some kind of way to update the database... 

    }

    // remove staff
    public void removeStaff() {
        // TODO
        // Some kind of way to delete the data in database
    }

    // display staff
    public void displayStaff() {
        System.out.printf("%-15s %-10s %-10s %-5s %-15s%n", "Name", "Gender", "ID", "Age", "Role");
        System.out.println("-------------------------------------------------------");

        // Display staff details
        for (Staff staff : staffList) {
            System.out.printf("%-15s %-10s %-10s %-5d %-15s%n", 
                staff.getName(), 
                staff.getGender(), 
                staff.getId(), 
                staff.getAge(),
                staff.getRole());
        }
    }
}
