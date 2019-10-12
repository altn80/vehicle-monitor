/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.repository;

import com.novaes.vehiclemonitor.domain.Customer;
import com.novaes.vehiclemonitor.domain.CustomerRepository;
import com.novaes.vehiclemonitor.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class CustomerVehicleRepositoryImpl implements CustomerRepository {

    final List<Customer> customers;

    public CustomerVehicleRepositoryImpl() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void add(Customer customer) {
        this.customers.add(customer);
    }

    @Override
    public void addVehicle(Customer customer, Vehicle vehicle) {
        customer.addVehicle(vehicle);
    }

}
