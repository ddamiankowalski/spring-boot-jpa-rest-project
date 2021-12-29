package com.example.jpapractiseproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfile, Long> {

}
