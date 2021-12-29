package com.example.jpapractiseproject;

import com.example.jpapractiseproject.entities.Device;
import com.example.jpapractiseproject.entities.Entry;
import com.example.jpapractiseproject.repositories.*;
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
	@Autowired
	private EntriesRepository entriesRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
