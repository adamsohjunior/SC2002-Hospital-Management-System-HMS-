import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Console;
import java.time.Year;

public class HMS {
    public static void main(String[] args) {
        System.out.println("System starting...");

        String medicineListPath = "../data/Medicine_List.csv";
        String patientListPath = "../data/Patient_List.csv";
        String staffListPath = "../data/Staff_List.csv";
        
        Inventory inventory = new Inventory();
        ArrayList<Prescription> medicineList = new ArrayList<>();
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<Administrator> adminList = new ArrayList<>();
        ArrayList<Pharmacist> pharmacistList = new ArrayList<>();

        ArrayList<User> users = new ArrayList<>();

        Available availableDates = new Available();
        ArrayList<Appointment> allAppointments = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(medicineListPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int amount = Integer.parseInt(data[1]);
                int alertThreshold = Integer.parseInt(data[2]);

                medicineList.add(new Prescription(name));   // May not be necessary
                inventory.add(name, new Stock(amount, alertThreshold));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(patientListPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String dob = data[2];
                String gender = data[3];
                String bloodType = data[4];
                String email = data[5];

                int currentYear = Year.now().getValue();
                int birthYear = Integer.parseInt(dob.substring(0, 4));
                int age = currentYear - birthYear;
                
                Patient patient = new Patient(id, name, age, email, bloodType, dob, availableDates, gender, allAppointments);

                patientList.add(patient);
                users.add(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(staffListPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String role = data[2];
                String gender = data[3];
                int age = Integer.parseInt(data[4]);
                
                switch (role) {
                    case "Doctor":
                        ArrayList<AppointmentOutcomeRecord> allAppointmentOutcomeRecords = new ArrayList<>();
                        Doctor doctor = new Doctor(id, name, age, gender, availableDates, allAppointmentOutcomeRecords);
                        doctorList.add(doctor);
                        users.add(doctor);
                        break;

                    case "Pharmacist":
                        Pharmacist pharmacist = new Pharmacist(id, name, age, gender);
                        pharmacistList.add(pharmacist);
                        users.add(pharmacist);
                        break;

                    case "Administrator":
                        Administrator admin = new Administrator(id, name, age, gender);
                        adminList.add(admin);
                        users.add(admin);
                        break;

                    default:
                        System.out.println("Invalid user role!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        String id, password, newPassword;
        User currentUser;
        while (true) {
            System.out.println("Welcome to HMS!");
            currentUser = null;

            // Prompt for ID
            while (true) {
                System.out.print("Enter hospital ID: ");
                id = scan.nextLine();
                for (int i = 0; i < users.size(); i++) {

                    if (id.equalsIgnoreCase(users.get(i).getUserId())) {
                        currentUser = users.get(i);
                        System.out.println("ID match found!");
                    }
                }
                if (currentUser != null) {
                    break;
                }
                System.out.println("ID not recognised. Try again");
            }
            
            // Prompt for password
            /*
             * Potential additional features:
             * - password validation
             */
            while (true) {
                System.out.print("Enter password: ");
                password = scan.nextLine();
                if (password.equals(currentUser.getPassword())) {
                    System.out.println("Login successful!");
                    if (password.equals("password")) {
                        // First login
                        System.out.println("Please change your password for security.");
                        while (true) {
                            System.out.print("Enter new password: ");
                            newPassword = scan.nextLine();

                            if (!newPassword.equals(password)) {
                                break;
                            }

                            System.out.println("New and old passwords are the same.");
                        }
                        
                        /*
                         * Additional feature: hidden password
                         */
                        // Console console = System.console();
                        // if (console == null) {
                        //     System.out.println("No console available");
                        //     return;
                        // }

                        // while (true) {
                        //     char[] passwordArray = console.readPassword("Enter new password: ");
                        //     password = new String(passwordArray);

                        //     passwordArray = console.readPassword("Confirm new password: ");
                        //     newPassword = new String(passwordArray);

                        //     if (password.equals(newPassword)) {
                        //         break;
                        //     }
                        //     System.out.println("Passwords do not match. Try again");
                        // }

                        currentUser.changePassword(newPassword);
                        System.out.println("Password changed successfully!");
                    }
                    currentUser.displayMenu();
                    break;
                }
                System.out.println("Wrong password. Try again");
            }
        }
    }  
}