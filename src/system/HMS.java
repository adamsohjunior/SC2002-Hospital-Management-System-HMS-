package system;
// import java.util.Scanner;

// import model.Appointment;
// import model.AppointmentOutcomeRecord;
// import model.Available;
// import model.Inventory;
// import model.Patient;
// import model.User;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.io.Console;
// import java.time.Year;

public class HMS {
    public static void main(String[] args) {
        // latest version
        SystemManager system = new SystemManager();
        system.initialise();
        system.loadData();
        system.runSystem();
        system.saveData();
        
        // // further improvement: create SystemInitializer and LoginManagement classes (facade pattern)
        // System.out.println("System starting...");

        // // Paths for file I/O
        // String medicineListPath = "../data/Medicine_List.csv";
        // String patientListPath = "../data/Patient_List.csv";
        // String staffListPath = "../data/Staff_List.csv";
        
        // // System (global) variables
        // ArrayList<Inventory> storage = null;
        // ArrayList<User> staffList = null;
        // Available availableDates = new Available();
        // ArrayList<Appointment> allAppointments = new ArrayList<>();
        // ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords = new ArrayList<>();

        // // Parsers for reading from CSV files
        // // DoctorParser doctorParser = new DoctorParser(availableDates, allAppointmentOutcomeRecords);
        // // PharmacistParser pharmacistParser = new PharmacistParser(availableDates, allAppointmentOutcomeRecords, storage);
        // // AdministratorParser administratorParser = new AdministratorParser();
        // PatientParser patientParser = new PatientParser(availableDates, allAppointments);
        // StaffParser staffParser = new StaffParser(availableDates, allAppointmentOutcomeRecords, storage, staffList, allAppointments);
        // InventoryParser inventoryParser = new InventoryParser();

        // // Role specific lists
        // ArrayList<Patient> patientList = new CSVReader<Patient>().read(patientListPath, patientParser);
        // staffList = new CSVReader<User>().read(staffListPath, staffParser);
        // storage = new CSVReader<Inventory>().read(medicineListPath, inventoryParser);

        // // ArrayList<Doctor> doctorList = new ArrayList<>();
        // // ArrayList<Administrator> adminList = new ArrayList<>();
        // // ArrayList<Pharmacist> pharmacistList = new ArrayList<>();

        // // Combined list of all users (for login)
        // ArrayList<User> users = new ArrayList<>(patientList);      
        // users.addAll(staffList);

        
        // // try (BufferedReader br = new BufferedReader(new FileReader(medicineListPath))) {
        // //     String line;
        // //     br.readLine();
        // //     while ((line = br.readLine()) != null) {
        // //         String[] data = line.split(",");
        // //         String name = data[0];
        // //         int amount = Integer.parseInt(data[1]);
        // //         int alertThreshold = Integer.parseInt(data[2]);

        // //         medicineList.add(new Prescription(name));   // May not be necessary
        // //         storage.add(new Inventory(name, amount, alertThreshold));
        // //     }
        // // } catch (IOException e) {
        // //     e.printStackTrace();
        // // }

        // // try (BufferedReader br = new BufferedReader(new FileReader(patientListPath))) {
        // //     String line;
        // //     br.readLine();
        // //     while ((line = br.readLine()) != null) {
        // //         String[] data = line.split(",");
        // //         String id = data[0];
        // //         String name = data[1];
        // //         String dob = data[2];
        // //         String gender = data[3];
        // //         String bloodType = data[4];
        // //         String email = data[5];

        // //         int currentYear = Year.now().getValue();
        // //         int birthYear = Integer.parseInt(dob.substring(0, 4));
        // //         int age = currentYear - birthYear;
                
        // //         Patient patient = new Patient(id, name, age, email, bloodType, dob, availableDates, gender, allAppointments);

        // //         patientList.add(patient);
        // //         users.add(patient);
        // //     }
        // // } catch (IOException e) {
        // //     e.printStackTrace();
        // // }

        // // try (BufferedReader br = new BufferedReader(new FileReader(staffListPath))) {
        // //     String line;
        // //     br.readLine();
        // //     while ((line = br.readLine()) != null) {
        // //         String[] data = line.split(",");
        // //         String id = data[0];
        // //         String name = data[1];
        // //         String role = data[2];
        // //         String gender = data[3];
        // //         int age = Integer.parseInt(data[4]);
                
        // //         switch (role) {
        // //             case "Doctor":
        // //                 Doctor doctor = new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords);
        // //                 doctorList.add(doctor);
        // //                 users.add(doctor);
        // //                 break;

        // //             case "Pharmacist":
        // //                 Pharmacist pharmacist = new Pharmacist(id, name, age, gender, availableDates, allAppointmentOutcomeRecords, storage);
        // //                 pharmacistList.add(pharmacist);
        // //                 users.add(pharmacist);
        // //                 break;

        // //             case "Administrator":
        // //                 Administrator admin = new Administrator(id, name, age, gender);
        // //                 adminList.add(admin);
        // //                 users.add(admin);
        // //                 break;

        // //             default:
        // //                 System.out.println("Invalid user role!");
        // //         }
        // //     }
        // // } catch (IOException e) {
        // //     e.printStackTrace();
        // // }

        // Scanner scan = new Scanner(System.in);
        // String id, password, newPassword;
        // User currentUser;
        // while (true) {
        //     System.out.println("Welcome to HMS!");
        //     currentUser = null;

        //     // Prompt for ID
        //     while (true) {
        //         System.out.print("Enter hospital ID: ");
        //         id = scan.nextLine();
        //         //
        //         //  insert empty input validation here
        //         //
        //         for (int i = 0; i < users.size(); i++) {

        //             if (id.equalsIgnoreCase(users.get(i).getUserId())) {
        //                 currentUser = users.get(i);
        //                 System.out.println("ID match found!");
        //             }
        //         }
        //         if (currentUser != null) {
        //             break;
        //         }
        //         System.out.println("ID not recognised. Try again");
        //     }
            
        //     // Prompt for password
        //     while (true) {
        //         System.out.print("Enter password: ");
        //         password = scan.nextLine();
        //         //
        //         // password validation (empty input and pattern matching)
        //         //
        //         if (password.equals(currentUser.getPassword())) {
        //             System.out.println("Login successful!");
        //             if (password.equals("password")) {
        //                 // First login
        //                 System.out.println("Please change your password for security.");
        //                 while (true) {
        //                     System.out.print("Enter new password: ");
        //                     newPassword = scan.nextLine();
        //                     //
        //                     // password validation (empty input and pattern matching)
        //                     //

        //                     if (!newPassword.equals(password)) {
        //                         break;
        //                     }

        //                     System.out.println("New and old passwords are the same.");
        //                 }
                        
        //                 /*
        //                  * Additional feature: hidden password
        //                  */
        //                 // Console console = System.console();
        //                 // if (console == null) {
        //                 //     System.out.println("No console available");
        //                 //     return;
        //                 // }

        //                 // while (true) {
        //                 //     char[] passwordArray = console.readPassword("Enter new password: ");
        //                 //     password = new String(passwordArray);

        //                 //     passwordArray = console.readPassword("Confirm new password: ");
        //                 //     newPassword = new String(passwordArray);

        //                 //     if (password.equals(newPassword)) {
        //                 //         break;
        //                 //     }
        //                 //     System.out.println("Passwords do not match. Try again");
        //                 // }

        //                 currentUser.changePassword(newPassword);
        //                 System.out.println("Password changed successfully!");
        //             }
        //             currentUser.displayMenu();
        //             break;
        //         }
        //         System.out.println("Wrong password. Try again");
        //     }
        // }
    }  
}