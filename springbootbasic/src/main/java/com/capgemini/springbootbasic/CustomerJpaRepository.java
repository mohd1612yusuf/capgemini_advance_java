package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

	// Basic
	Customer findByEmail(String email);

	Customer findByNameAndEmail(String name, String email);

	Customer findByNameOrEmail(String name, String email);

	// Range Queries
	List<Customer> findByIdBetween(int start, int end);

	List<Customer> findByAgeGreaterThan(int age);

	List<Customer> findByIdLessThan(int id);

	// Null Checks
	List<Customer> findByEmailIsNull();

	List<Customer> findByEmailIsNotNull();

	// LIKE Queries
	List<Customer> findByNameContaining(String keyword); // %keyword%

	List<Customer> findByNameStartingWith(String prefix); // prefix%

	List<Customer> findByNameEndingWith(String suffix); // %suffix

	// Case Insensitive
	List<Customer> findByNameIgnoreCase(String name);

	// Sorting / Limiting
	Customer findTop1ByOrderByIdDesc();

	List<Customer> findFirst3ByName(String name);
}