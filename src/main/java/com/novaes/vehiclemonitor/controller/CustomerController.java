/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novaes.vehiclemonitor.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.novaes.vehiclemonitor.domain.vehicle.Vehicle;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleStatus;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import com.novaes.vehiclemonitor.domain.customer.CustomerRepository;

/**
 *
 * @author andre
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    void loadData() throws IOException {
        loadCustomers();
    }

    private void loadCustomers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = mapper.readValue(getClass().getResourceAsStream("/customers.json"), new TypeReference<List<Customer>>() {
        });
        customers.forEach(customerRepository::add);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerRepository.findAllCustomers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customers/{id}")
    public Customer customersById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

}
