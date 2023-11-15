package com.morello.ds_assignment1_device_microservice.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;
    private String address;
    private Integer maxHourlyEnergyConsumption;
    @Column(nullable = true)
    private String username;

    public Devices(String name, String description, String address, Integer maxHourlyEnergyConsumption, String username) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.maxHourlyEnergyConsumption = maxHourlyEnergyConsumption;
        this.username = username;
    }
}
