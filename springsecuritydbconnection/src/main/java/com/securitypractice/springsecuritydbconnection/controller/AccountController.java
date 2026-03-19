package com.securitypractice.springsecuritydbconnection.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.security.AccountService;

@RestController
public class AccountController {
	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		return service.createAccount(dto);
	}

	@GetMapping("/find-id/{id}")
	public AccountResponseDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}

//	@GetMapping("/find-id/{id}")
//	public AccountResponseDTO getById(@PathVariable Long id, Authentication authentication) {
//		return service.getById(id, authentication.getName());
//	}

	@GetMapping("/admin/all")
	public Object getAll(Authentication authentication) {
		return service.getAll(authentication.getName());
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "Account deleted successfully";
	}

}
