package com.lithan.serverletone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.lithan.serverletone.User;
import com.lithan.serverletone.DBConnection;
import com.lithan.serverletone.Product;

public class ApplicationnDao {
	public List<Product> searchProducts(String searchString) {
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try{
			Connection connection = DBConnection.getConnectionToDatabase();
					//getConnectionToDatabase();
			
			String sql = "select * from products where product_name like '%"+searchString+"%'";
			
			Statement statement = connection.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				product= new Product();
				product.setProductId(set.getInt("product_id"));
				product.setProductImgPath(set.getString("image_path"));
				product.setProductName(set.getString("product_name"));
				products.add(product);
				
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		return products;
}
	public int registerUser(User user) {
		int rowsAffected = 0;

		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the insert query
			String insertQuery = "insert into users(`username`,`password`, `firstname`, `lastname`, `age`, `activity`) values(?,?,?,?,?,?)";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setInt(5, user.getAge());
			statement.setString(6, user.getActivity());

			// execute the statement
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}

	
	public Boolean loginUser(String username, String password) {
		Boolean auth = false;
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String selectQuery = "select * from users where username=\""+username+"\"";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(selectQuery);
			
			while(set.next()) {
				if(set.getString("password").equals(password)) {
					System.out.println("user logged");
					return true;
				}else {
					System.out.println("invalid password");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("user does not exist");
		return auth;
	}
	
}
