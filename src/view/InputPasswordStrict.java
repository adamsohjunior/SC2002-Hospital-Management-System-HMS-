package view;


/**
 * Handles user input for a password with stricter validation rules.
 * Implements the InputString interface to retrieve a password input from the user.
 * The class ensures that the password is not empty and adheres to a strict format, 
 * which includes at least one uppercase letter, one lowercase letter, one digit, and one special character.
 * 
 * <p>The password must meet the following criteria:</p>
 * <ul>
 *     <li>At least 8 characters long</li>
 *     <li>Contains at least one uppercase letter</li>
 *     <li>Contains at least one lowercase letter</li>
 *     <li>Contains at least one digit</li>
 *     <li>Contains at least one special character (e.g., !@#$%^&*)</li>
 * </ul>
 * 
 */

public class InputPasswordStrict implements InputString {

    /**
     * Prompts the user to enter a password with strict validation.
     * The method checks for empty input and enforces a strict password format.
     * If the input doesn't match the required format, the user is prompted to enter the password again.
     * 
     * @return the valid password entered by the user that meets the strict format requirements.
     */
    
    public String getStringInput() {
        String password;

        while (true) {
            password = scan.nextLine();
            // Empty input validation
            if (password.isEmpty()) {
                DisplayLog.display("Password cannot be empty.\n");
                DisplayPrompt.display("Enter new password: ");
                continue;
            }
            // Format validation (source: regex101.com)
            if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,}$")) {
                DisplayLog.display("Invalid password format.\n");
                DisplayPrompt.display("Enter new password: ");
                continue;
            }
            break;
        }

        return password;
    }
}