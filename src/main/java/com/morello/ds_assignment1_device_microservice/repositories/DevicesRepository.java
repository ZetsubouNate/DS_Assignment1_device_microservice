package com.morello.ds_assignment1_device_microservice.repositories;

import com.morello.ds_assignment1_device_microservice.entities.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevicesRepository extends JpaRepository<Devices, Integer> {
    List<Devices> findByUsername(String username);
    List<Devices> findByNameContainingOrderById(String devicesName);
    List<Devices> findAllByOrderByName();
}
