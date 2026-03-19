package com.example.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
	@GetMapping("/practices")
	public String getDetails() {
		return "Details";
	}

	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}
}
