package com.morello.ds_assignment1_device_microservice.repositories;

import com.morello.ds_assignment1_device_microservice.entities.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevicesRepository extends JpaRepository<Devices, Integer> {
    List<Devices> findByUserId(Integer userId);
    List<Devices> findAllByOrderByUserIdAsc();
    List<Devices> findAllByOrderByNameAsc();
    List<Devices> findAllByOrderByIdAsc();
}
