package com.example.jpapractiseproject.repositories;

import com.example.jpapractiseproject.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("select d from Device d where d.deviceName = ?1")
    Device getDeviceByDeviceName(String name);
}
