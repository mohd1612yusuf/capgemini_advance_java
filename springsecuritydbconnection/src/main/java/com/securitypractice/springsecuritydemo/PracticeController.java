package com.securitypractice.springsecuritydemo;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "htpp://localhost:3000")
public class PracticeController {
	@PostMapping("/public")
	public String getDetails() {
		return "details";
	}

	@GetMapping("/admin")
	public String deleteUser() {
		return "delete";
	}

	@GetMapping("/csrf-token")
	public CsrfToken getCsrf(CsrfToken token) {
		return token;
	}

}
