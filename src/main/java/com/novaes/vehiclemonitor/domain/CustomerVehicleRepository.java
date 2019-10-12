/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andre
 */
public interface CustomerVehicleRepository {

    public void add(Customer customer);

    public void addVehicle(Customer customer, Vehicle vehicle);
    
    List<Customer> findAllCustomers();

    Customer findCustomerById(Integer id);

    List<Vehicle> findVehicles(Customer customer);

    List<Vehicle> findVehicles(Customer customer, VehicleStatus status);
    

}
