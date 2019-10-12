/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novaes.vehiclemonitor.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.novaes.vehiclemonitor.domain.CustomerVehicleRepository;
import com.novaes.vehiclemonitor.domain.Vehicle;
import com.novaes.vehiclemonitor.domain.VehicleStatus;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author andre
 */
@RestController
public class VehicleMonitorController {

    @Autowired
    CustomerVehicleRepository customerRepository;

    @PostConstruct
    void loadData() throws IOException {
        loadCustomers();
        loadVehicles();
    }

    private void loadCustomers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = mapper.readValue(getClass().getResourceAsStream("/customers.json"), new TypeReference<List<Customer>>() {});
        customers.forEach(customer -> {
            customerRepository.add(customer);
        });
    }

    private void loadVehicles() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = mapper.readValue(getClass().getResourceAsStream("/vehicles.json"), new TypeReference<List<Vehicle>>() {});
        vehicles.forEach(vehicle -> {
            Customer customer = customerRepository.findCustomerById(vehicle.getIdCustomer());
            customerRepository.addVehicle(customer, vehicle);
        });
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vehicles/{id}")
    public List<Vehicle> vehiclesByCustomer(@PathVariable Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        return customerRepository.findVehicles(customer);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vehicles/{id}/{status}")
    public List<Vehicle> vehiclesByStatus(@PathVariable Integer id, @PathVariable String status) {
        Customer customer = customerRepository.findCustomerById(id);
        return customerRepository.findVehicles(customer, VehicleStatus.valueOf(status));
    }

}
