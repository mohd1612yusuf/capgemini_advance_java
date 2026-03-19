package com.securityjwt.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securityjwt.jwt.entity.UserInformation;
import com.securityjwt.jwt.repo.UserJpaRepository;

public class UserAuthenticationService implements UserDetailsService {
	private UserJpaRepository userjpa;

	public UserAuthenticationService(UserJpaRepository userjpa) {
		super();
		this.userjpa = userjpa;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserInformation> info = userjpa.findById(email);
		if (info.isPresent()) {
			System.out.println("User Authenticated Service: " + email);
			return null;
		} else {
			throw new UsernameNotFoundException("Username with email " + email + " not found");
		}
	}
}
