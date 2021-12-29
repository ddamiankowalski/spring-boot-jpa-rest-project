package com.example.jpapractiseproject.repositories;

import com.example.jpapractiseproject.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntriesRepository extends JpaRepository<Entry, Long> {

}
