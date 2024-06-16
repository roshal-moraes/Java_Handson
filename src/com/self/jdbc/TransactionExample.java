package com.self.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Disable auto-commit
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                // Perform multiple SQL operations
                statement.executeUpdate("INSERT INTO employees (employee_name) VALUES ('John')");
                statement.executeUpdate("UPDATE departments SET budget = budget - 10000 WHERE department_name = 'IT'");

                // If no exceptions, commit the transaction
                connection.commit();
                System.out.println("Transaction committed successfully");
            } catch (SQLException e) {
                // Rollback the transaction in case of an exception
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
