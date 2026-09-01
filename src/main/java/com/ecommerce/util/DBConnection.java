package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        String url = System.getenv().getOrDefault(
            "DB_URL",
            "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        String user = System.getenv().getOrDefault("DB_USER", "ecommerce");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "ecommerce");
        return DriverManager.getConnection(url, user, password);
    }
}
