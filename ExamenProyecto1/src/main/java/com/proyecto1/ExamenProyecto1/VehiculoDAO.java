/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: Alex Fernandez
 */

public class VehiculoDAO {
    public static List<Vehiculo> getAllVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT * FROM Vehiculo";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getString("tipo"),
                        rs.getString("marca"),
                        rs.getInt("potencia"),
                        rs.getDate("fechaCompra")
                );
                vehiculo.setId(rs.getLong("id_vehiculo"));
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiculos;
    }

    public static Vehiculo getVehiculoById(Long id) {
        Vehiculo vehiculo = null;
        String query = "SELECT * FROM Vehiculo WHERE id_vehiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getString("tipo"),
                        rs.getString("marca"),
                        rs.getInt("potencia"),
                        rs.getDate("fechaCompra")
                );
                vehiculo.setId(rs.getLong("id_vehiculo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiculo;
    }

    public static void insertVehiculo(Vehiculo vehiculo) {
        String query = "INSERT INTO Vehiculo (tipo, marca, potencia, fechaCompra) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, vehiculo.getTipo());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setInt(3, vehiculo.getPotencia());
            pstmt.setDate(4, vehiculo.getFechaCompra());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateVehiculo(Vehiculo vehiculo) {
        String query = "UPDATE Vehiculo SET tipo = ?, marca = ?, potencia = ?, fechaCompra = ? WHERE id_vehiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, vehiculo.getTipo());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setInt(3, vehiculo.getPotencia());
            pstmt.setDate(4, vehiculo.getFechaCompra());
            pstmt.setLong(5, vehiculo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteVehiculo(Long id) {
        String query = "DELETE FROM Vehiculo WHERE id_vehiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
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