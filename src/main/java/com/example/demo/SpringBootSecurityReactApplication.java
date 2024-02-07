package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.enums.Role;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityReactApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityReactApplication.class, args);
	}

	public void run(String... args) throws Exception {
		User role = userRepository.findByRole(Role.ADMIN);
		if (null == role){
			User user = new User();
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setEmail("admin@gmail.com");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
