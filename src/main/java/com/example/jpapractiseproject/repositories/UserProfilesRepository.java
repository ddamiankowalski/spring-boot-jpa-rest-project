package com.example.jpapractiseproject.repositories;

import com.example.jpapractiseproject.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfile, Long> {

}
