package Classes.DataValidation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import Classes.DBConnection;
import Classes.User;

public class EmailValidation {
	public static String emailRegex="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	
	public Boolean emailValidate(String email) {
		Pattern emailPattern = Pattern.compile(emailRegex);
		return emailPattern.matcher(email).matches();
	}
	
	public Boolean checkEmail(String email) {
		User user = null;
		ArrayList<User> users = new ArrayList<>();
		
		try{
			//establishing connection
			Connection connection = DBConnection.getConnectionToDatabase();
			
			//retrieving email address if existing
			String retrieveExistingUser = "select * where User_Email = "+ email;
			
			//statement creation and execution
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(retrieveExistingUser);
			
			//looping thru
			while(set.next()) {
				user = new User();
				user.setEmailAddress(set.getString("User_Email"));
				System.out.println(user.getEmailAddress());
				if(user.getEmailAddress().equals(email)) {
					System.out.println("user already existing");
					return true;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
