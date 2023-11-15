package com.morello.ds_assignment1_device_microservice.services;

import com.morello.ds_assignment1_device_microservice.entities.Devices;

import java.util.List;
import java.util.Optional;

public interface DevicesService {
    List<Devices> getAllDevices();

    List<Devices> getAllDevicesByName();

    Optional<Devices> getDeviceById(Integer id);

    List<Devices> getDevicesByName(String name);

    List<Devices> getDevicesByUser(String username);

    void addDevice(Devices device);

    void updateDevice(Integer id, Devices device);

    void updateUsernameForDevices(String username);

    void deleteDevice(Devices devices);

}
