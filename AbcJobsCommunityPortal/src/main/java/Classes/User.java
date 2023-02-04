package Classes;

public class User {

	//user property
	private int User_ID;
	private String firstName;
	private String lastName;
	private String password;
	private String emailAddress;
	
	public User(String firstName, String lastName, String password, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		//this.emailaddress = emailAddress;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public User() {
		
	}

	
}

