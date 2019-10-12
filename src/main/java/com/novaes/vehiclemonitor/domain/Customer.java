/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Customer {

    private final Integer id;
    private final String name;
    private final String address;
    private final List<Vehicle> fleet;

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fleet = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getOwner() != null) {
            throw new IllegalArgumentException("Vehicle belongs to a fleet");
        }
        vehicle.belongsTo(this);
        this.fleet.add(vehicle);
    }

}
