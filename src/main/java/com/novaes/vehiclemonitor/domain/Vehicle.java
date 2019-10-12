/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain;

/**
 *
 * @author andre
 */
public class Vehicle {

    private final String id;
    private final String registrationNumber;
    private final VehicleStatus status;
    private Customer owner;

    public Vehicle(String id, String registrationNumber) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.status = VehicleStatus.OFF;
    }

    public String getId() {
        return id;
    }

    public Customer getOwner() {
        return owner;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    void belongsTo(Customer owner) {
        this.owner = owner;
    }

}
