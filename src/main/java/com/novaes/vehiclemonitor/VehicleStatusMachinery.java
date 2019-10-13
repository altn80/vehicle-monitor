/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.vehiclemonitor;

import com.novaes.vehiclemonitor.domain.vehicle.VehicleRepository;
import com.novaes.vehiclemonitor.domain.vehicle.VehicleStatus;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */
@EnableScheduling
@Component
public class VehicleStatusMachinery {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Scheduled(fixedRate = 5000L)
    public void status() {
        Random random = new Random();
        vehicleRepository.findAll().forEach(vehicle -> vehicle.updateStatus(VehicleStatus.values()[random.nextInt(2)]));
    }

}
