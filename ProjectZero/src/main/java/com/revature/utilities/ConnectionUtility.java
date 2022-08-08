package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection != null) {
			return connection;
		}else {
			try {
				Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url = "jdbc:postgresql://javafs220725.cyypgegi3m5d.us-east-1.rds.amazonaws.com:5432/project_zero";
			String username = "postgres"; 
			String password = "password1"; 
			
			connection = DriverManager.getConnection(url,username,password);
				}
		return connection;
		}
	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

