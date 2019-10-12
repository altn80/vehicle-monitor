/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

import com.novaes.vehiclemonitor.domain.Customer;
import com.novaes.vehiclemonitor.domain.Vehicle;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class CustomerTest {

    @Test
    public void testNewCustomer() {
        Customer customer = new Customer(1, "Customer 1", "100 Bay Street");
        Assert.assertThat(customer.getId(), is(1));
        Assert.assertThat(customer.getName(), is("Customer 1"));
        Assert.assertThat(customer.getAddress(), is("100 Bay Street"));
        Assert.assertThat(customer.getFleet(), is(Collections.EMPTY_LIST));
    }

    @Test
    public void testAddVehicle() {
        Customer customer = new Customer(1, "Customer 1", "100 Bay Street");
        Vehicle vehicle = new Vehicle("YS2R4X20005399401", "ABC123");
        customer.addVehicle(vehicle);
        Assert.assertThat(customer.getFleet().size(), is(1));
        Assert.assertThat(customer.getFleet().get(0), is(vehicle));
    }

    @Test
    public void testAddExistingVehicle() {
        Customer customer = new Customer(1, "Customer 1", "100 Bay Street");
        Vehicle vehicle = new Vehicle("YS2R4X20005399401", "ABC123");
        customer.addVehicle(vehicle);
        try {
            customer.addVehicle(vehicle);
            Assert.fail("Test failed");
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Vehicle belongs to a fleet"));
        }
    }

}
