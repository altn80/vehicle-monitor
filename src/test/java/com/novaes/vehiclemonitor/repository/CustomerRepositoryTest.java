/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.repository;

import com.novaes.vehiclemonitor.domain.customer.CustomerRepositoryImpl;
import com.novaes.vehiclemonitor.domain.customer.Customer;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.novaes.vehiclemonitor.domain.customer.CustomerRepository;

/**
 *
 * @author andre
 */
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    @Before
    public void init() {
        this.customerRepository = new CustomerRepositoryImpl();
    }

    @After
    public void destroy() {
        this.customerRepository = null;
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "Customer 1", "100 Bay Street");
        customerRepository.add(customer);
        Assert.assertThat(customer, is(customerRepository.findCustomerById(1)));
    }

}
