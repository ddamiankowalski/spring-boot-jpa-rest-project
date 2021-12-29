package com.example.jpapractiseproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JpaPractiseProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JpaPractiseProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JpaPractiseProjectApplication.class);
	}
}



@Component
class DemoCommandLineRunner implements CommandLineRunner{
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserProfilesRepository profileRepository;
	@Autowired
	private OfficeRepository officeRepository;
	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user = new User("Damian", "Kowalski", "damian@gmail.com");
//		repository.save(user);
//
//		User secondUser = new User("Kamil", "Wieczarek", "kamil@gmail.com");
//		repository.save(secondUser);
//
//		UserProfile userProfile = new UserProfile("+484921", Gender.MALE, "Poland");
//		userProfile.setUser(user);
//		profileRepository.save(userProfile);
//
//		Office office = new Office(650L, user);
//		officeRepository.save(office);
//		Office office1 = new Office(223L, secondUser);
//		officeRepository.save(office1);
//
//		Device device1 = new Device("Samsung");
//		Device device2 = new Device("Motorola");
//		device1.setOffice(office);
//		device2.setOffice(office);
//		deviceRepository.save(device1);
//		deviceRepository.save(device2);
	}
}
