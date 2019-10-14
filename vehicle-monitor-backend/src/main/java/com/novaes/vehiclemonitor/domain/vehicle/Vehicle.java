/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.vehicle;

import java.util.Random;

/**
 *
 * @author andre
 */
public class Vehicle {

    private final String id;
    private final String registrationNumber;
    private VehicleStatus status;
    private final Integer idCustomer;

    public Vehicle() {
        this.id = null;
        this.registrationNumber = null;
        this.status = null;
        this.idCustomer = null;
    }

    public Vehicle(String id, String registrationNumber, Integer idCustomer) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.status = VehicleStatus.OFF;
        this.idCustomer = idCustomer;
    }

    public String getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleStatus getStatus() {
       return this.status;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }
    
    public void updateStatus(VehicleStatus status) {
        this.status = status;
    }

}
