/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

/**
 *
 * @author: Alex Fernandez
 */

public class VehiculoDAO {
    public static void printVehiculoDetails(){
        String query = "SELECT * FROM Vehiculo;";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

            while(rs.next()){
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia");
                Date fechaCompra = rs.getDate("fechaCompra")
                System.out.println(" ID: " + id + " , tipo: " + tipo + " , marca: " + marca + " , potencia: " + potencia + " , fechaCompra: " + fechaCompra);


            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}

/*
 private String tipo;
    private String marca;
    private int potencia;
    private Date fechaCompra;
 */