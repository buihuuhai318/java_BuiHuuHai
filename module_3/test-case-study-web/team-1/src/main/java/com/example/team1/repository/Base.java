package com.example.team1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/thehome";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Csdltdg318";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
