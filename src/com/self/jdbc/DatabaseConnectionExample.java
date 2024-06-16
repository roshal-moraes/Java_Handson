package com.self.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionExample {
	public static void main(String[] args) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String user = "username";
		String password = "password";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement()) {

			// Execute a simple query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

			// Process the result set
			while (resultSet.next()) {
				String employeeName = resultSet.getString("employee_name");
				int employeeId = resultSet.getInt("employee_id");
				System.out.println("Employee ID: " + employeeId + ", Name: " + employeeName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
