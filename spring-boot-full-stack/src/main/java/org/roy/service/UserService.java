package org.roy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.roy.model.Role;
import org.roy.model.User;
import org.roy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void createAdmin(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public Optional<User> findOne(String email) {
		return userRepository.findById(email);
	}

	public boolean isUserPresent(String email) {
		return findOne(email).isPresent();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		return userRepository.findByNameLike("%"+name+"%");
	}
}
