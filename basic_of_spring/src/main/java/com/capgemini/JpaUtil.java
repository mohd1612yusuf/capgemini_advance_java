package com.capgemini;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Component
public class JpaUtil {
	private EntityManagerFactory emf;
	private EntityManager entityManager;

	@PostConstruct
	public void createConnection() {
		emf = Persistence.createEntityManagerFactory("postgres");
		entityManager = emf.createEntityManager();
		System.out.println("Connection");
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PreDestroy
	public void print() {
		entityManager.close();
		emf.close();
	}
}
