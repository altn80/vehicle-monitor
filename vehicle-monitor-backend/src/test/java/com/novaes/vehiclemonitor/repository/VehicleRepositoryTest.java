/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.repository;

import com.novaes.vehiclemonitor.domain.customer.Customer;
import com.novaes.vehiclemonitor.domain.vehicle.Vehicle;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleRepository;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleRepositoryImpl;

/**
 *
 * @author andre
 */
public class VehicleRepositoryTest {

    private VehicleRepository vehicleRepository;

    @Before
    public void init() {
        this.vehicleRepository = new VehicleRepositoryImpl();
    }

    @After
    public void destroy() {
        this.vehicleRepository = null;
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle("1", "Vehicle 1", 1);
        vehicleRepository.add(vehicle);
        Assert.assertThat(vehicle, is(vehicleRepository.findVehicles(1)));
    }
    
    @Test
    public void testFindCustomers() {
        vehicleRepository.add(new Vehicle("1", "Vehicle 1", 1));
        vehicleRepository.add(new Vehicle("2", "Vehicle 5", 1));
        vehicleRepository.add(new Vehicle("3", "Vehicle 6", 1));
        vehicleRepository.add(new Vehicle("4", "Vehicle 7", 1));
        vehicleRepository.add(new Vehicle("5", "Vehicle 8", 1));
        Assert.assertThat(5, is(vehicleRepository.findAll().size()));
    }

}
