package com.example.jpapractiseproject.entities;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;
    private String entryInformation;

    Entry() {};

    public Entry(String entryInformation) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        this.date = zonedDateTime.format(formatter);
        this.entryInformation = entryInformation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getEntryInformation() {
        return entryInformation;
    }

    public void setEntryInformation(String entryInformation) {
        this.entryInformation = entryInformation;
    }
}
