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
    private String name;
    @Column(length = 2000)
    private String description;
    private String address;
    private Integer maxHourlyEnergyConsumption;
    private Integer userId;
}
