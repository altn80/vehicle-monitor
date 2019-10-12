/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

import com.novaes.vehiclemonitor.domain.Vehicle;
import com.novaes.vehiclemonitor.domain.VehicleStatus;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class VehicleTest {

    @Test
    public void testNewVehicle() {
        Vehicle vehicle = new Vehicle("YS2R4X20005399401", "ABC123");
        Assert.assertThat(vehicle.getId(), is("YS2R4X20005399401"));
        Assert.assertThat(vehicle.getRegistrationNumber(), is("ABC123"));
        Assert.assertThat(vehicle.getStatus(), is(VehicleStatus.OFF));
        Assert.assertThat(vehicle.getOwner(), IsNull.nullValue());
    }

}
