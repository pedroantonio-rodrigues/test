package com.register.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.register.domain.Activity;
import com.register.domain.Address;
import com.register.domain.People;
import com.register.domain.User;
import com.register.repositories.ActivityRepository;
import com.register.repositories.AddressRepository;
import com.register.repositories.PeopleRepository;
import com.register.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Configuration
@Profile("testes")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	@Transactional
	public void run(String... arg) throws Exception {
		
		User user1 = new User(null, "fulano", "12345678");
		userRepository.save(user1);
		
		People p1 = new People(null, "João Silva", "123456789", "fulano@example.com", null, null);
		p1.setUser(user1);
		peopleRepository.save(p1);
		
	Address ad1 = new Address(null, "Rua a", "cidade x", 123, "Complemento", p1);
		addressRepository.save(ad1);
		
		Activity ac1 = new Activity(null, "Atividade 1", new Date(), new Date(), new Date(), p1);
		activityRepository.save(ac1);
		
	}

}
