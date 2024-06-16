package com.self.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE employees SET salary = ? WHERE employee_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDouble(1, 55000.0);
                preparedStatement.setString(2, "John Doe");

                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println(rowsAffected + " row(s) updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
