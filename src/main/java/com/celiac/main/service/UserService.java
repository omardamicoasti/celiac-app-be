package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.User;

public interface UserService {
	void saveUser(User user);
	List<User> getAll();
	Optional<User> findByUsername(String username);
	void deleteUser(User user);
}
