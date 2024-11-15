package view;


public class InputID implements InputString {
    

    public String getStringInput() {
        String id;

        while (true) {
            DisplayPrompt.display("Enter hospital ID: ");
            id = scan.nextLine();
            // Empty input validation
            if (id.isEmpty()) {
                DisplayLog.display("ID cannot be empty.\n");
                continue;
            }
            // Format validation (source: regex101.com)
            if (!id.matches("^[A-Za-z]\\d+$")) {
                DisplayLog.display("Invalid ID format.\n");
                continue;
            }
            break;
        }

        return id;
    }
}
