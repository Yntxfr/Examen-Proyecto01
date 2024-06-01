/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto1.ExamenProyecto1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex Fernandez
 */

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return VehiculoDAO.getAllVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        Vehiculo vehiculo = VehiculoDAO.getVehiculoById(id);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createVehiculo(@RequestBody Vehiculo vehiculo) {
        VehiculoDAO.insertVehiculo(vehiculo);
        return ResponseEntity.status(201).body("Vehículo creado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculoDetails) {
        Vehiculo vehiculo = VehiculoDAO.getVehiculoById(id);
        if (vehiculo != null) {
            vehiculo.setTipo(vehiculoDetails.getTipo());
            vehiculo.setMarca(vehiculoDetails.getMarca());
            vehiculo.setPotencia(vehiculoDetails.getPotencia());
            vehiculo.setFechaCompra(vehiculoDetails.getFechaCompra());
            VehiculoDAO.updateVehiculo(vehiculo);
            return ResponseEntity.ok("Vehículo actualizado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehiculo(@PathVariable Long id) {
        Vehiculo vehiculo = VehiculoDAO.getVehiculoById(id);
        if (vehiculo != null) {
            VehiculoDAO.deleteVehiculo(id);
            return ResponseEntity.ok("Vehículo eliminado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
