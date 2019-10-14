/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.vehicle;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author andre
 */
public class Vehicle {

    private String id;
    private String registrationNumber;
    private VehicleStatus status;
    private Integer idCustomer;

    public Vehicle() {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
