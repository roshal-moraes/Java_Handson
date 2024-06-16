package com.self.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Using a PreparedStatement
            String sql = "SELECT * FROM employees WHERE department = ? and id = ?" ;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "IT");
                preparedStatement.setInt(2, 45);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String employeeName = resultSet.getString("employee_name");
                    int employeeId = resultSet.getInt("employee_id");
                    System.out.println("Employee ID: " + employeeId + ", Name: " + employeeName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
