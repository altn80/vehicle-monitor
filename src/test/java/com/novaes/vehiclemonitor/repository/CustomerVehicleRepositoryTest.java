/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.repository;

import com.novaes.vehiclemonitor.domain.Customer;
import com.novaes.vehiclemonitor.domain.CustomerVehicleRepository;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class CustomerVehicleRepositoryTest {

    private CustomerVehicleRepository customerVehicleRepository;

    @Before
    public void init() {
        this.customerVehicleRepository = new CustomerVehicleRepositoryImpl();
    }

    @After
    public void destroy() {
        this.customerVehicleRepository = null;
    }
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "Customer 1", "100 Bay Street");
        customerVehicleRepository.add(customer);
        Assert.assertThat(customer, is(customerVehicleRepository.findCustomerById(1)));
    }

}
