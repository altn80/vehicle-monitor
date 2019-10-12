package com.novaes.vehiclemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VehicleMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleMonitorApplication.class, args);
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/customers").allowedOrigins("http://localhost:4200");
                registry.addMapping("/vehicles").allowedOrigins("http://localhost:4200");

            }
        };
    }

}
