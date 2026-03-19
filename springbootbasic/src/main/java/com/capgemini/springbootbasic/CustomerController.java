package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerJpaRepository cjpa;

	@PostMapping
	public Customer createCustomer(@RequestBody Customer c) {
		return cjpa.save(c);
	}

	@GetMapping("/id/{id}")
	public Customer findById(@PathVariable int id) {
		return cjpa.findById(id).orElse(null);
	}

	@GetMapping("/email/{email}")
	public Customer findByEmail(@PathVariable String email) {
		return cjpa.findByEmail(email);
	}

	@GetMapping("/name-email")
	public Customer findByNameAndEmail(@RequestParam String name, @RequestParam String email) {
		return cjpa.findByNameAndEmail(name, email);
	}

	@GetMapping("/name-or-email")
	public Customer findByNameOrEmail(@RequestParam String name, @RequestParam String email) {
		return cjpa.findByNameOrEmail(name, email);
	}

	@GetMapping("/id-between")
	public List<Customer> findByIdBetween(@RequestParam int start, @RequestParam int end) {
		return cjpa.findByIdBetween(start, end);
	}

	@GetMapping("/age-greater/{age}")
	public List<Customer> findByAgeGreaterThan(@PathVariable int age) {
		return cjpa.findByAgeGreaterThan(age);
	}

	@GetMapping("/id-less/{id}")
	public List<Customer> findByIdLessThan(@PathVariable int id) {
		return cjpa.findByIdLessThan(id);
	}

	@GetMapping("/email-null")
	public List<Customer> findEmailIsNull() {
		return cjpa.findByEmailIsNull();
	}

	@GetMapping("/email-not-null")
	public List<Customer> findEmailIsNotNull() {
		return cjpa.findByEmailIsNotNull();
	}

	@GetMapping("/name-contains/{keyword}")
	public List<Customer> findByNameContaining(@PathVariable String keyword) {
		return cjpa.findByNameContaining(keyword);
	}

	@GetMapping("/name-start/{prefix}")
	public List<Customer> findByNameStartingWith(@PathVariable String prefix) {
		return cjpa.findByNameStartingWith(prefix);
	}

	@GetMapping("/name-end/{suffix}")
	public List<Customer> findByNameEndingWith(@PathVariable String suffix) {
		return cjpa.findByNameEndingWith(suffix);
	}

	@GetMapping("/name-ignore/{name}")
	public List<Customer> findByNameIgnoreCase(@PathVariable String name) {
		return cjpa.findByNameIgnoreCase(name);
	}

	@GetMapping("/latest")
	public Customer findTop1ByOrderByIdDesc() {
		return cjpa.findTop1ByOrderByIdDesc();
	}

	@GetMapping("/first3/{name}")
	public List<Customer> findFirst3ByName(@PathVariable String name) {
		return cjpa.findFirst3ByName(name);
	}
}