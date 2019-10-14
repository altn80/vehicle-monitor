/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

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
