package com.example.jpapractiseproject.controllers;

import com.example.jpapractiseproject.entities.Device;
import com.example.jpapractiseproject.entities.Entry;
import com.example.jpapractiseproject.repositories.DeviceRepository;
import com.example.jpapractiseproject.repositories.EntriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EntriesController {
    @Autowired
    private EntriesRepository entriesRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/entries/{device}")
    public List<Entry> entryList(@PathVariable(name = "device") String deviceName) {
        Device device = deviceRepository.getDeviceByDeviceName(deviceName);
        List<Entry> result = device.getEntryList();
        result.forEach(entry -> System.out.println(entry.getEntryInformation()));
        return result;
    }

    @PostMapping("/entries")
    public Entry newEntry(@RequestBody Entry entry, @RequestParam(name = "dName", required = true) String deviceName) {
        Device device = deviceRepository.getDeviceByDeviceName(deviceName);
        Entry newEntry = new Entry(entry.getEntryInformation());
        newEntry.setDevice(device);
        device.getEntryList().add(newEntry);
        entriesRepository.save(newEntry);
        return entry;
    }

    @DeleteMapping("/entries/{id}")
    public Map<String, Boolean> deleteEntry(@PathVariable(name = "id") Long id) {
        Entry entry = entriesRepository.findById(id).orElseThrow();

        entriesRepository.delete(entry);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
