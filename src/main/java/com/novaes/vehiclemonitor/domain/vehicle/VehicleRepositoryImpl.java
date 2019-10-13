/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.vehicle;

import com.novaes.vehiclemonitor.domain.customer.*;
import com.novaes.vehiclemonitor.domain.customer.Customer;
import com.novaes.vehiclemonitor.domain.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.novaes.vehiclemonitor.domain.customer.CustomerRepository;
import java.util.Objects;

/**
 *
 * @author andre
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    final List<Vehicle> vehicles;

    public VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(Vehicle vehicle) {
        if (this.vehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle already exists");
        }
        this.vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findVehicles(Integer idCustomer) {
        return this.vehicles
                .stream()
                .filter(vehicle -> Objects.equals(vehicle.getIdCustomer(), idCustomer))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findVehicles(Integer idCustomer, VehicleStatus status) {
        return this.vehicles
                .stream()
                .filter(vehicle -> Objects.equals(vehicle.getIdCustomer(), idCustomer) && vehicle.getStatus() == status)
                .collect(Collectors.toList());
    }
    

}
