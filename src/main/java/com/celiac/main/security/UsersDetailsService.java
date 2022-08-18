package com.celiac.main.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.celiac.main.repository.UserRepository;

@Configuration
public class UsersDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;

	public UsersDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			
			com.celiac.main.model.User user = userRepository.findByUsername(username).get();
			
			if(user != null) {
				
				System.out.println("--------PWD USERDETAILS-------- " + user.getPassword());
				
				return User.withUsername(user.getUsername())
							.password(user.getPassword())
							.build();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		throw new UsernameNotFoundException(username);
	}

}

