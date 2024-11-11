package view;

public class InputPasswordStrict implements InputString {
    public String getStringInput() {
        String password;

        while (true) {
            password = scan.nextLine();
            // Empty input validation
            if (password.isEmpty()) {
                DisplayLog.display("Password cannot be empty.");
                DisplayPrompt.display("Enter password: ");
                continue;
            }
            // Format validation (source: regex101.com)
            if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,}$")) {
                DisplayLog.display("Invalid password format.");
                DisplayPrompt.display("Enter password: ");
                continue;
            }
            break;
        }

        return password;
    }
}