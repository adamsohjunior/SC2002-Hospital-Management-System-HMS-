public abstract class User {
	private String userId;
	private String password = "password";
	private String name;
	private int age;
	private String gender;
	
	public User(String id, String name, int age, String gender) {
		userId = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public abstract void displayMenu();
}
