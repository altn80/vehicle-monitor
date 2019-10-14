/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

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

/**
 *
 * @author andre
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    final List<Customer> customers;

    public CustomerRepositoryImpl() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void add(Customer customer) {
        if (this.customers.contains(customer)) {
            throw new IllegalArgumentException("Customer already exists");
        }
        this.customers.add(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return this.customers;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return this.customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

}
