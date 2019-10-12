/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain;

import com.novaes.vehiclemonitor.domain.Customer;

/**
 *
 * @author andre
 */
public interface CustomerRepository {
    
    public void add(Customer customer);

    void addVehicle(Customer customer, Vehicle vehicle);
    
}
