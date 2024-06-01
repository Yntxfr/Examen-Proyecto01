/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import java.util.Date;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

/**
 *
 * @author: Alex Fernandez
 */

public class Vehiculo {
    // private Long id_vehiculo;
    private String tipo;
    private String marca;
    private int potencia;
    private Date fechaCompra;


    public Vehiculo(String tipo, String marca, int potencia, Date fechaCompra) {
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaCompra = fechaCompra;
        VehiculoDAO.insertVehiculo(tipo, marca, potencia, fechaCompra);
    }

    public String getVehiculo() {
        return VehiculoDAO.getUserVehiculo(this.marca);
    }

    public String insertVehiculo() {
        return VehiculoDAO.insertVehiculo(this.tipo, this.marca, this.potencia);
    }
}


// Getters and Setters
/*
public Long getId_vehiculo() {
    return id_vehiculo;
}

public void setId_vehiculo(Long id_vehiculo) {
    this.getId_vehiculo = id_vehiculo;
}
*/

/*
id_vehiculo INT NOT NULL AUTO_INCREMENT,
tipo VARCHAR(45),
marca VARCHAR(45) NOT NULL,
potencia INT NOT NULL,
fechaCompra DATETIME DEFAULT NOW(),
-- potencia INT NOT NULL UNIQUE,

PRIMARY KEY (id_vehiculo)
);
 */
