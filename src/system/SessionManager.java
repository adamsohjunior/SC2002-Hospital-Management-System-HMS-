package system;

import model.User;
import view.DisplayPrompt;
import view.DisplayLog;
import view.InputID;
import view.InputPassword;

import java.util.ArrayList;

public class SessionManager {
    private String id, password, newPassword;
    private User currentUser;
    private ArrayList<User> users;

    public SessionManager(ArrayList<User> users) {
        this.users = users;
    }

    public void startNewSession() {
        currentUser = null;
        getUserID();
        getPassword();
    }

    private void getUserID() {
        InputID input = new InputID();

        while (true) {
            DisplayPrompt.display("Enter hospital ID: ");
            id = input.getStringInput();

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
    }

    private void getPassword() {
        InputPassword input = new InputPassword();
        while (true) {
            DisplayPrompt.display("Enter password: ");
            password = input.getStringInput();
            
            if (password.equals(currentUser.getPassword())) {
                DisplayLog.display("Login successful!");
                if (password.equals("password")) {
                    // First login
                    DisplayLog.display("Please change your password for security.");
                    while (true) {
                        DisplayPrompt.display("Enter new password: ");
                        newPassword = input.getStringInput();

                        if (!newPassword.equals(password)) {
                            break;
                        }

                        DisplayPrompt.display("New and old passwords are the same.");
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
                    DisplayLog.display("Password changed successfully!");
                }
                currentUser.displayMenu();
                break;
            }
            DisplayLog.display("Wrong password. Try again");
        }
    }
}
