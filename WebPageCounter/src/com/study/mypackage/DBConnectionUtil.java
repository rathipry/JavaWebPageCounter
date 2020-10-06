package com.study.mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * Utility class to connect with database server.
 * This class will have common database connection related methods.
 * Not any project specific methods added in this class.
 * added mysql-connector-java-8.0.13.jar under WEB-INF/lib to connect Java-Mysql
 */
public class DBConnectionUtil {

	static Connection connection = null;

	//open database connection. Single connection is used so made it as static
	public static Connection openConnection() {
		if (connection == null) {

			// define fields
			String username = "root";
			String pwd = "helloworld123";
			String jdbcURL = "jdbc:mysql://localhost:3306/counterdb";
			String driver = "com.mysql.jdbc.Driver";

			try {
				// Load the driver
				Class.forName(driver);

				// Get the connection
				connection = DriverManager.getConnection(jdbcURL, username, pwd);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return connection;

	}
	
	//To close connection with database server
	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
