package system;

import model.User;
import view.DisplayPrompt;
import view.DisplayLog;
import view.InputID;
import view.InputPassword;
import view.InputPasswordStrict;

import java.util.ArrayList;

/**
 * SessionManager class to manage session
 */
public class SessionManager {
    private String id, password, newPassword;
    private User currentUser;
    private ArrayList<User> users;

    /**
     * constructs SessionManager object with the given details
     * 
     * @param users the list of all users 
     */
    public SessionManager(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * method to start new session when a new user login
     */
    public void startNewSession() {
        currentUser = null;
        getUserID();
        getPassword();
    }

    /**
     * method to prompt user to enter Hospital ID
     */
    private void getUserID() {
        InputID input = new InputID();

        while (true) {
            id = input.getStringInput();

            for (int i = 0; i < users.size(); i++) {
                if (id.equalsIgnoreCase(users.get(i).getUserId())) {
                    currentUser = users.get(i);
                    System.out.println("ID match found!\n");
                }
            }
            if (currentUser != null) {
                break;
            }
            System.out.println("ID not recognised. Try again\n");
        }
    }

    /**
     * method to prompt user to enter their password
     */
    private void getPassword() {
        InputPassword input = new InputPassword();
        InputPasswordStrict inputStrict = new InputPasswordStrict();

        while (true) {
            DisplayPrompt.display("Enter password: ");
            password = input.getStringInput();
            
            if (password.equals(currentUser.getPassword())) {
                DisplayLog.display("Login successful!\n");
                if (password.equals("password")) {
                    // First login
                    DisplayLog.display("Please change your password for security.");
                    while (true) {
                        DisplayPrompt.display("Enter new password: ");
                        newPassword = inputStrict.getStringInput();
                        break;

                        // if (!newPassword.equals(password)) {
                        //     break;
                        // }

                        // DisplayLog.display("New and old passwords are the same.\n");
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
                    DisplayLog.display("Password changed successfully!\n");
                }
                currentUser.displayMenu();
                break;
            }
            DisplayLog.display("Wrong password. Try again\n");
        }
    }
}
