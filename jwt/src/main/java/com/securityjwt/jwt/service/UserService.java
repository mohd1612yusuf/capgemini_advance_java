package com.securityjwt.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityjwt.jwt.UserInformationDTO;
import com.securityjwt.jwt.entity.UserInformation;
import com.securityjwt.jwt.repo.UserJpaRepository;

@Service
public class UserService {
	UserJpaRepository userjpa;

	@Autowired
	BCryptPasswordEncoder encodepassword;

	public UserService(UserJpaRepository userjpa) {
		this.userjpa = userjpa;
	}

	public UserInformation createUser(UserInformationDTO dto) {
		UserInformation info = new UserInformation();
		info.setEmailId(dto.getEmailId());
		info.setName(dto.getName());
		info.setPassword(encodepassword.encode(dto.getPassword()));
		info.setPhone(dto.getPhone());
		return userjpa.save(info);
	}
}
