/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Alex Fernandez
 */

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ExamenProyecto01";
    private static final String USER = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER);
    }

}

