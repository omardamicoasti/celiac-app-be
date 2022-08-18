package com.celiac.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.User;
import com.celiac.main.repository.UserRepository;
import com.celiac.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository u;

	@Override
	public void saveUser(User user) {
		u.save(user);
	}

	@Override
	public List<User> getAll() {
		return u.findAll();
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return u.findById(username);
	}

	@Override
	public void deleteUser(User user) {
		u.delete(user);
	}

}