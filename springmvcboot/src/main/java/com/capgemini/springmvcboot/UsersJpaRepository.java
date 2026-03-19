package com.capgemini.springmvcboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<Users, String> {
	public Users findByEmailAndPassword(String email, String password);
}
