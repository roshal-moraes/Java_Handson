package com.self.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO employees (employee_name, salary) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "John Doe");
                preparedStatement.setDouble(2, 50000.0);

                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println(rowsAffected + " row(s) inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
