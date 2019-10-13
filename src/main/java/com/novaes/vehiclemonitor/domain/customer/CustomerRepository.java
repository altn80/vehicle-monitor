/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

import com.novaes.vehiclemonitor.domain.vehicle.Vehicle;
import java.util.List;

/**
 *
 * @author andre
 */
public interface CustomerRepository {

    public void add(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(Integer id);

}
