/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor.domain.customer;

/**
 *
 * @author andre
 */
public class Customer {
    
    private final Integer id;
    private final String name;
    private final String address;

    public Customer() {
        this.id = null;
        this.name = null;
        this.address = null;
    }
    
    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
}
