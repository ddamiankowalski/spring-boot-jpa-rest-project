package com.example.jpapractiseproject.repositories;

import com.example.jpapractiseproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.firstName = ?1")
    List<User> getUserByFirstName(String name);

    @Query("select u from User u where u.lastName = ?1")
    List<User> getUserByLastName(String lastName);
}
