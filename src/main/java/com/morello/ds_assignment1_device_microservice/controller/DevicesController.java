package com.morello.ds_assignment1_device_microservice.controller;

import com.morello.ds_assignment1_device_microservice.entities.Devices;
import com.morello.ds_assignment1_device_microservice.services.DevicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DevicesController {

    private final DevicesService devicesService;
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Devices>> getAllDevices() {
        List<Devices> devices = devicesService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Devices>> getUserDevices(@PathVariable String username) {
        List<Devices> devices = devicesService.getDevicesByUser(username);
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/all/name")
    public ResponseEntity<List<Devices>> orderDevicesByName() {
        List<Devices> devices = devicesService.getAllDevicesByName();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/find/id")
    public ResponseEntity<Devices> getDevice(@RequestParam Integer id) {
        Optional<Devices> device = devicesService.getDeviceById(id);
        if (device.isPresent()) {
            return ResponseEntity.ok(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<Devices>> getDevice(@RequestParam String name) {
        List<Devices> devices = devicesService.getDevicesByName(name);
        if (!devices.isEmpty()) {
            return ResponseEntity.ok(devices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDevice(@RequestParam Integer id) {
        Optional<Devices> device = devicesService.getDeviceById(id);

        if (device.isPresent()) {
            devicesService.deleteDevice(device.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Devices> addDevice(@RequestParam String name, @RequestParam String description, @RequestParam String address, @RequestParam Integer maxHourlyEnergyConsumption, @RequestParam String username) {
        Devices device = new Devices(name, description, address, maxHourlyEnergyConsumption, username);
        if(username.isEmpty())
            device.setUsername(null);
        devicesService.addDevice(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Devices> updateDevice(@PathVariable Integer id, @RequestBody Devices device) {
        Optional<Devices> existingDevice = devicesService.getDeviceById(id);

        if (existingDevice.isPresent()) {
            Devices updatedDevice = existingDevice.get();
            updatedDevice.setName(device.getName());
            updatedDevice.setDescription(device.getDescription());
            updatedDevice.setAddress(device.getAddress());
            updatedDevice.setMaxHourlyEnergyConsumption(device.getMaxHourlyEnergyConsumption());
            updatedDevice.setUsername(device.getUsername());
            devicesService.updateDevice(id, updatedDevice);
            return ResponseEntity.ok(updatedDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-username")
    public ResponseEntity<Void> updateUsernameForDevices(@RequestParam String username) {
        devicesService.updateUsernameForDevices(username);
        return ResponseEntity.noContent().build();
    }
}
