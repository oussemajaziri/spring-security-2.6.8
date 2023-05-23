package com.oj.springsecurity;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oj.springsecurity.domain.Role;
import com.oj.springsecurity.domain.User;
import com.oj.springsecurity.services.UserService;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "ouss jaz", "jaz", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "leonel messi", "leo", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "foulen", "foulen", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "foulena", "foulena", "123", new ArrayList<>()));

			userService.addRoleToUser("foulen", "ROLE_USER");
			userService.addRoleToUser("foulen", "ROLE_MANAGER");
			userService.addRoleToUser("foulena", "ROLE_MANAGER");
			userService.addRoleToUser("leo", "ROLE_ADMIN");
			userService.addRoleToUser("jaz", "ROLE_USER");
			userService.addRoleToUser("jaz", "ROLE_ADMIN");
			userService.addRoleToUser("jaz", "ROLE_SUPER_ADMIN");
		};
	}

}
