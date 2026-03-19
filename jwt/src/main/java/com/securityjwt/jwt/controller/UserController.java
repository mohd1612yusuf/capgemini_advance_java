package com.securityjwt.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securityjwt.jwt.LoginDTO;
import com.securityjwt.jwt.UserInformationDTO;
import com.securityjwt.jwt.entity.UserInformation;
import com.securityjwt.jwt.service.UserService;
import com.securityjwt.jwt.util.JWTUtil;

@RestController
public class UserController {
	@Autowired
	JWTUtil util;

	private UserService service;

	@Autowired
	private AuthenticationManager authentication;

	@GetMapping("/{username}")
	public String user(@PathVariable String username) {
		return util.createToken(username);
	}

	@GetMapping("get-user/{token}")
	public String getUserName(@PathVariable String token) {
		return util.getUserName(token);
	}

	@GetMapping("validate/{user}/{token}")
	public boolean isTokenValid(@PathVariable String user, @PathVariable String token) {
		return util.isValidateToken(user, token);
	}

	@PostMapping("/public/create")
	public UserInformation createUser(@PathVariable UserInformationDTO dto) {
		return service.createUser(dto);
	}

	@PostMapping("/public/user/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
		UsernamePasswordAuthenticationToken credentials=new UsernamePasswordAuthenticationToken(dto.getEmailId(), dto.getPassword());
		Authentication auth = authentication.authenticate(credentials);
		System.out.println(auth.getCredentials());
		String token=util.createToken(dto.getEmailId());
		HttpHeaders responseHeader=new HttpHeaders();
		responseHeader.add("Authorization", token);
		return new ResponseEntity<String>("Welcome to home: "+dto.getEmailId(), HttpStatus.ACCEPTED);)
	}
}
