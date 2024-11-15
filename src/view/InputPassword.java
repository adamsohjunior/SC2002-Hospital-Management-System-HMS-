package view;

public class InputPassword implements InputString {
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