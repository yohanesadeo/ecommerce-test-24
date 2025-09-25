package com.juaracoding.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.juaracoding.ecommerce.configurations.DBConfiguration;

public class DBConnectionUtility {
    public static Connection connect() throws SQLException {

        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");

            // Get database credentials from Config class
            String url = DBConfiguration.getDbUrl();
            String user = DBConfiguration.getDbUsername();
            String password = DBConfiguration.getDbPassword();

            // Open a connection
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }

    }
}
