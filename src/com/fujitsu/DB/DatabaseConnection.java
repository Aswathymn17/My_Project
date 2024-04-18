package com.fujitsu.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {



	  public static Connection getConnection(String serverName,String userName,String passwd) throws SQLException {
	        String url = "jdbc:sqlserver://"+serverName+";databaseName=GlobalSTORE1;encrypt=true;trustServerCertificate=true";// Replace with your database URL
	        String username = userName; // Replace with your database username
	        String password = passwd; // Replace with your database password

	        return DriverManager.getConnection(url, username, password);

	    }
}
