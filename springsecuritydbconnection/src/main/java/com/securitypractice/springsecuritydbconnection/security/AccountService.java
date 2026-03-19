package com.securitypractice.springsecuritydbconnection.security;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.entity.Account;
import com.securitypractice.springsecuritydbconnection.repo.AccountJpaRepository;

@Service
public class AccountService {
	private AccountJpaRepository jpa;
	private PasswordEncoder encode;

	public AccountService(AccountJpaRepository jpa, PasswordEncoder encode) {
		this.jpa = jpa;
		this.encode = encode;
	}

	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if (jpa.existsByUsername(dto.getUsername())) {
			throw new RuntimeException("User name exists");
		}
		if (jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User email exists");
		}
		Account account = new Account();
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		account.setCreatedAt(dto.getCreatedAt());
		account.setEmail(dto.getEmail());
		account.setRole(normalizeAndValidateRole(dto.getRole()));
		jpa.save(account);
		return toResponse(account);
	}

	public String normalizeAndValidateRole(String role) {
		if (role == null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}
		String r = role.trim().toUpperCase();
		if (!r.startsWith("ROLE_")) {
			r = "ROLE_" + r;
		}
		if (!r.equals("ROLE_USER") && !r.equals("ROLE_ADMIN")) {
			throw new RuntimeException("Role not found");
		}
		return r;
	}

	public AccountResponseDTO toResponse(Account a) {
		AccountResponseDTO dto = new AccountResponseDTO();
		dto.setEmail(a.getEmail());
		dto.setPhone(a.getPhone());
		dto.setFullname(a.getFullname());
		dto.setUsername(a.getUsername());
		return dto;
	}

	@PostAuthorize("hasRole('ADMIN') or returnObject.username==authentication.name")
	public AccountResponseDTO getById(long id) {
		Account a = jpa.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		return toResponse(a);
	}

//	public AccountResponseDTO getById(long id, String loggedInUsername) {
//		Account requestedAccount = jpa.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
//		Account loggedInUser = jpa.findByUsername(loggedInUsername)
//				.orElseThrow(() -> new RuntimeException("User not found"));
//		if (loggedInUser.getRole().equals("ROLE_ADMIN")) {
//			return toResponse(requestedAccount);
//		}
//		if (!requestedAccount.getUsername().equals(loggedInUsername)) {
//			throw new RuntimeException("You are not allowed to view this data");
//		}
//		return toResponse(requestedAccount);
//	}

	public Object getAll(String username) {
		Account loggedInUser = jpa.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
		if (loggedInUser.getRole().equals("ROLE_ADMIN")) {
			return jpa.findAll().stream().map(this::toResponse).toList();
		}
		return toResponse(loggedInUser);
	}

	public void deleteById(Long id) {
		Account account = jpa.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		jpa.delete(account);
	}
}
