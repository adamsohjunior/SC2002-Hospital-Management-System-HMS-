package view;

public class InputPassword implements InputString {
    public String getStringInput() {
        String password;

        while (true) {
            DisplayPrompt.display("Enter hospital ID: ");
            password = scan.nextLine();
            // Empty input validation
            if (password.isEmpty()) {
                DisplayLog.display("Password cannot be empty.");
                continue;
            }
            // Format validation (source: regex101.com)
            if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,}$")) {
                DisplayLog.display("Invalid password format.");
                /*
                 * Additional feature: check password requirements
                 */
                continue;
            }
            break;
        }

        return password;
    }
}