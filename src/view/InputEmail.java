package view;


/**
 * Class to prompt an input for an Email choice
 */
public class InputEmail implements InputString{
	/**
	 * To get an Email input from User.
	 * Email input is to be checked for validity(Robustness)
	 * Returns validified email input by User
	 */
	public String getStringInput() {
		String email ="";
		boolean validity = false;
		while(!validity) {
			System.out.println("Please enter your email: ");
			email = scan.nextLine();
			        if (email == null || email.isEmpty()) {
			            System.out.println("You have not entered any email!");
			        	continue;
			        }
			        int atIndex = email.indexOf('@');
			        int lastAtIndex = email.lastIndexOf('@');
			        if (atIndex == -1 || atIndex != lastAtIndex) {
			        	System.out.println("Please enter a valid email address! ");
			        	continue;
			        }

			        String fronttPart = email.substring(0, atIndex);
			        String domainPart = email.substring(atIndex + 1);

			        if (fronttPart.isEmpty() || domainPart.isEmpty()) {
			        	System.out.println("Please enter a valid email address! ");
			        	continue;
			        }

			        int dottsIndex = domainPart.indexOf('.');
			        if (dottsIndex == -1 || dottsIndex == 0 || dottsIndex == domainPart.length() - 1) {
			        	System.out.println("Please enter a valid email address! ");
			        	continue;
			        }


			        validity = true;
			    }
		return email;

	}
}
