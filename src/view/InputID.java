package view;


public class InputID implements InputString {
    

    public String getStringInput() {
        String id;

        while (true) {
            DisplayPrompt.display("Enter hospital ID: ");
            id = scan.nextLine();
            // Empty input validation
            if (id.isEmpty()) {
                DisplayLog.display("ID cannot be empty.");
                continue;
            }
            // Format validation (source: regex101.com)
            if (!id.matches("^[A-Za-z]\\d+$")) {
                DisplayLog.display("Invalid ID format.");
                continue;
            }
            break;
        }

        return id;
    }
}
