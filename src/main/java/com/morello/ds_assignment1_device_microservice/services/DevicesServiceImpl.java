package com.morello.ds_assignment1_device_microservice.services;

import com.morello.ds_assignment1_device_microservice.entities.Devices;
import com.morello.ds_assignment1_device_microservice.repositories.DevicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevicesServiceImpl implements DevicesService{
    private final DevicesRepository devicesRepository;

    @Override
    public List<Devices> getAllDevices() {
        return null;
    }

    @Override
    public Optional<Devices> getDeviceById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Devices> getDevicesByName(String name) {
        return Optional.empty();
    }
}
