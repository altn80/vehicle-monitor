/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.vehicle;

import java.util.List;

/**
 *
 * @author andre
 */
public interface VehicleRepository {

    public void add(Vehicle vehicke);
    
    public List<Vehicle> findAll();

    public List<Vehicle> findVehicles(Integer idCustomer);

    public List<Vehicle> findVehicles(Integer idCustomer, VehicleStatus status);
    

}
