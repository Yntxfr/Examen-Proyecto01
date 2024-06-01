/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
// import java.util.Date;
import java.sql.Date;
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
                Date fechaCompra = rs.getDate("fechaCompra");
                System.out.println(" ID: " + id + " , tipo: " + tipo + " , marca: " + marca + " , potencia: " + potencia + " , fechaCompra: " + fechaCompra);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertVehiculo(String tipo, String marca, int potencia, Date fechaCompra){
        String query = "INSERT INTO vehiculo(tipo, marca, potencia, fechaCompra) VALUES (?,?,?,?);";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setString(1, tipo);
            pstmt.setString(2, marca);
            pstmt.setInt(3, potencia);
            pstmt.setDate(4, fechaCompra);
            pstmt.executeUpdate();
            System.out.println("Nuevo vehiculo registrado!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteVehiculo(int id, String tipo){
        String query = "DELETE FROM vehiculo where id = ? and tipo = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id);
            pstmt.setString(2, tipo);
            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateVehiculo(String tipo, String modelo, int potencia, Date fechaCompra){
        String query = "UPDATE vehiculo ";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setString(1, tipo);
            pstmt.setString(2, modelo);
            pstmt.setInt(3, potencia);
            pstmt.setDate(4, fechaCompra);
            pstmt.executeUpdate();

            System.out.println("Email actualizado!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static String getUserVehiculo(String marca){
        String fechaCompra = "";
        String query = "SELECT marca FROM list where fechaCompra = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setString(1,marca);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                fechaCompra = rs.getString("fechaCompra");
                System.out.println(" fechaCompra: " + fechaCompra );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return fechaCompra;
    }


}

/*
 private String tipo;
    private String marca;
    private int potencia;
    private Date fechaCompra;
 */