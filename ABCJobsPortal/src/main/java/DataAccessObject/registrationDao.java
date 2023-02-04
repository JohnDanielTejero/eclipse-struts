package DataAccessObject;

import java.sql.Connection;
import java.sql.SQLException;

import Classes.DBConnection;
import Classes.User;



public class registrationDao {
	public int registerUser(User user) {
		int rowsAffected = 0;

		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the insert query
			String insertQuery = "insert into user(`User_FirstName`,`User_LastName`, `User_Password`, `User_Email`,`Role_ID`) values(?,?,?,?,?)";
			
			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			
			//set the parameters of the insert query
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmailAddress());
			statement.setInt(5, 1);
			
			// execute the statement
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}

	
}
