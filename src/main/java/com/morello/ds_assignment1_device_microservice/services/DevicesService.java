package com.morello.ds_assignment1_device_microservice.services;

import com.morello.ds_assignment1_device_microservice.entities.Devices;

import java.util.List;
import java.util.Optional;

public interface DevicesService {
    List<Devices> getAllDevices();

    Optional<Devices> getDeviceById(Integer id);

    Optional<Devices> getDevicesByName(String name);


}
