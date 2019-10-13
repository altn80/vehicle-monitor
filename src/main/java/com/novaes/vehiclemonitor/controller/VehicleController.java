/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.novaes.vehiclemonitor.domain.vehicle.Vehicle;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleStatus;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author andre
 */
@RestController
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @PostConstruct
    void loadData() throws IOException {
        loadVehicles();
    }

    private void loadVehicles() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = mapper.readValue(getClass().getResourceAsStream("/vehicles.json"), new TypeReference<List<Vehicle>>() {
        });
        vehicles.forEach(vehicleRepository::add);
    }

    @GetMapping("/vehicles/{idCustomer}")
    public List<Vehicle> vehiclesByCustomer(@PathVariable Integer idCustomer) {
        return vehicleRepository.findVehicles(idCustomer);
    }

    @GetMapping("/vehicles/{idCustomer}/{status}")
    public List<Vehicle> vehiclesByStatus(@PathVariable Integer idCustomer, @PathVariable String status) {
        return vehicleRepository.findVehicles(idCustomer, VehicleStatus.valueOf(status));
    }

}
