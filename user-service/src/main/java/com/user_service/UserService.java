package com.user_service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserJpaRepository jpa;

	public UserService(UserJpaRepository jpa) {
		this.jpa = jpa;
	}

	public String createUser(UserInformation info) {
		jpa.save(info);
		return "Data saved";
	}

	public UserInformation findUser(String emailId) {
		return jpa.findById(emailId).orElseThrow(() -> new RuntimeException("Email does not exist"));
	}
}