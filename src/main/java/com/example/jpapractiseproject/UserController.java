package com.example.jpapractiseproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProfilesRepository profileRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<User> listAll(@Nullable @RequestParam(value = "name", required = false)String name) {
        List<User> userList = new ArrayList<>();
        if(name == null) {
            userList = repository.findAll();
        } else {
            userList = repository.getUserByFirstName(name);
            if(userList.isEmpty()) {
                userList = repository.getUserByLastName(name);
            }
        }
        return userList;
    }

    @GetMapping("/users/{id}/profile")
    @ResponseBody
    public UserProfile getUserProfile(@PathVariable(value = "id") Long id) {
        User user = repository.findById(id).orElseThrow();
        UserProfile userProfile = user.getUserProfile();
        UserProfile result = new UserProfile(userProfile.getPhoneNumber(), userProfile.getGender(), userProfile.getCountry());
        return result;
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Long Id) {
        User result = repository.findById(Id).orElseThrow();
        return result;
    }

    @PostMapping("/users/{id}/profile")
    public UserProfile newProfile(@RequestBody UserProfile profile, @PathVariable(value = "id") Long id) {
        User user = repository.findById(id).orElseThrow();
        UserProfile newProfile = new UserProfile(profile.getPhoneNumber(), profile.getGender(), profile.getCountry());
        newProfile.setUser(user);
        user.setUserProfile(newProfile);
        return profileRepository.save(newProfile);
    }

    @PutMapping("users/{id}/profile")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable(value = "id") Long id, @RequestBody UserProfile userProfileDetails) {
        User user = repository.findById(id).orElseThrow();
        UserProfile userProfile = user.getUserProfile();
        userProfile.setPhoneNumber(userProfileDetails.getPhoneNumber());
        userProfile.setGender(userProfileDetails.getGender());
        userProfile.setCountry(userProfileDetails.getCountry());

        final UserProfile updatedUserProfile = profileRepository.save(userProfile);
        return ResponseEntity.ok(updatedUserProfile);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value="id") Long id, @RequestBody User userDetails) {
        User user = repository.findById(id).orElseThrow();

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        final User updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) {
        User user = repository.findById(id).orElseThrow();

        repository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
