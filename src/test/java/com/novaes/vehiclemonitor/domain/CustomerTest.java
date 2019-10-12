/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain;

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
    }

}
