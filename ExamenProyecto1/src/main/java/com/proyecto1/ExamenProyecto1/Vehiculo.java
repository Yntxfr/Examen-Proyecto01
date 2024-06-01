/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import java.sql.Date;


/**
 *
 * @author: Alex Fernandez
 */

public class Vehiculo {
    private Long id;
    private String tipo;
    private String marca;
    private int potencia;
    private Date fechaCompra;

    public Vehiculo(String tipo, String marca, int potencia, Date fechaCompra) {
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaCompra = fechaCompra;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public java.sql.Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


}


