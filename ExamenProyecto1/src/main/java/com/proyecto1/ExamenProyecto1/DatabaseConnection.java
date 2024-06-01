/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Alex Fernandez
 */

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ExamenProyecto01";
    private static final String USER = "root";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        return DriverManager.getConnection(URL, properties);
    }

}

