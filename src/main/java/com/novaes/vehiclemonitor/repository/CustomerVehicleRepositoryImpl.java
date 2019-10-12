/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.repository;

import com.novaes.vehiclemonitor.domain.Customer;
import com.novaes.vehiclemonitor.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import com.novaes.vehiclemonitor.domain.CustomerVehicleRepository;
import com.novaes.vehiclemonitor.domain.VehicleStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andre
 */
@Repository
public class CustomerVehicleRepositoryImpl implements CustomerVehicleRepository {

    final Map<Customer, List<Vehicle>> customers;

    public CustomerVehicleRepositoryImpl() {
        this.customers = new HashMap<>();
    }

    @Override
    public void add(Customer customer) {
        if (this.customers.containsKey(customer)) {
            throw new IllegalArgumentException("Customer already exists");
        }
        this.customers.put(customer, new ArrayList<>());
    }

    @Override
    public void addVehicle(Customer customer, Vehicle vehicle) {
        if (!this.customers.containsKey(customer)) {
            throw new IllegalArgumentException("Customer doesnt exist");
        }
        customers.get(customer).add(vehicle);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return this.customers.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return this.customers.keySet().stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }
    
    @Override
    public List<Vehicle> findVehicles(Customer customer) {
        return this.customers.get(customer)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findVehicles(Customer customer, VehicleStatus status) {
        return this.customers.get(customer)
                .stream()
                .filter(vehicle -> vehicle.getStatus() == status)
                .collect(Collectors.toList());
    }
    

}
