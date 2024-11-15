package view;

/**
 * The {@code InputString} interface defines a contract for classes that handle user input of type {@code String}.
 * This interface extends the {@link Input} interface and includes a method for obtaining a string input from the user.
 * Classes that implement this interface must provide their own implementation for obtaining and returning a string.
 * 
 * <p>Example usage:</p>
 * <pre>
 * InputString input = new InputPassword();
 * String password = input.getStringInput();
 * </pre>
 * 
 */

public interface InputString extends Input {
	
	public String getStringInput();
	
}
