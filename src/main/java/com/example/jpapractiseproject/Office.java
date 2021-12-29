package com.example.jpapractiseproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "office_number")
    private Long officeNumber;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_owner")
    private User user;
    @OneToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Device> deviceList = new ArrayList<>();

    public Office() {};

    public Office(Long officeNumber, User user) {
        this.officeNumber = officeNumber;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Long officeNumber) {
        this.officeNumber = officeNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
