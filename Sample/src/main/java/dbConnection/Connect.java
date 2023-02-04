package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static Connection connection;
	public static Connection connectToDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc_portal", "root", "Ks1auhJ!");
		}catch(ClassNotFoundException e){
			System.out.println("where is your driver?");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("connection failed");
			e.printStackTrace();
		}
		if (connection !=null) {
			System.out.println("connected successfully");
		}
		return connection;
	}
	
}
