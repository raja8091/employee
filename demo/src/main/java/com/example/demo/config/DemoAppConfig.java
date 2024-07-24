package com.example.demo.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



public class DemoAppConfig implements WebMvcConfigurer{
	
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
	
	
}
