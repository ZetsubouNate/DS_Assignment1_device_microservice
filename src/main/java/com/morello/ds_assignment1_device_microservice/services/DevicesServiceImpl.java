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
        return devicesRepository.findAll();
    }

    @Override
    public List<Devices> getAllDevicesByName() {
        return devicesRepository.findAllByOrderByName();
    }

    @Override
    public Optional<Devices> getDeviceById(Integer id) {
        return devicesRepository.findById(id);
    }

    @Override
    public List<Devices> getDevicesByName(String name) {
        return devicesRepository.findByNameContainingOrderById(name);
    }

    @Override
    public List<Devices> getDevicesByUser(String username) {
        return devicesRepository.findByUsername(username);
    }

    @Override
    public void addDevice(Devices device) {
        devicesRepository.save(device);
    }

    @Override
    public void updateDevice(Integer id, Devices device) {
        Optional<Devices> existingDevice = devicesRepository.findById(id);
        if(existingDevice.isPresent()) {
            devicesRepository.save(device);
        }
    }

    @Override
    public void updateUsernameForDevices(String username) {
        List<Devices> devices = devicesRepository.findByUsername(username);

        for (Devices device : devices) {
            device.setUsername(null);
            devicesRepository.save(device);
        }
    }

    @Override
    public void deleteDevice(Devices devices) {
        devicesRepository.delete(devices);
    }
}
