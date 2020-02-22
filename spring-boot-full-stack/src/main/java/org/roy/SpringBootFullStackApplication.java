package org.roy;

import org.roy.model.User;
import org.roy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFullStackApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFullStackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin@email.com", "Admin", "admin");
		userService.createAdmin(admin);
	}

}