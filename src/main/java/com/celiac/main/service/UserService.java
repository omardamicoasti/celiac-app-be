package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.User;

@Service
public interface UserService {
	User saveUser(User user);
	List<User> getAll();
	Optional<User> findByUsername(String username);
	void deleteUser(User user);
}
