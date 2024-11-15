package view;

/**
 * Handles user input for a password, ensuring the password is not empty.
 * Implements the InputString interface to retrieve a string input from the user.
 * The class repeatedly prompts the user to input a password until a non-empty value is provided.
 * 
 */

public class InputPassword implements InputString {

    /**
     * Prompts the user to enter a password and ensures it is not empty.
     * If the input is empty, the user is prompted to re-enter the password.
     * 
     * @return the non-empty password entered by the user.
     */
    
    public String getStringInput() {
        String password;

        while (true) {
            password = scan.nextLine();
            // Empty input validation
            if (password.isEmpty()) {
                DisplayLog.display("Password cannot be empty.\n");
                DisplayPrompt.display("Enter password: ");
                continue;
            }
            break;
        }

        return password;
    }
}