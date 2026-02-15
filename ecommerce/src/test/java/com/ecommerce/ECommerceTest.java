package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import entity.Profile;
import entity.User;
import service.ECommerceService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ECommerceTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private ECommerceService service;

	@BeforeAll
	void setupFactory() {
		emf = Persistence.createEntityManagerFactory("ecommercePU");
	}

	@BeforeEach
	void setup() {
		em = emf.createEntityManager();
		service = new ECommerceService(em);
	}

	@AfterEach
	void close() {
		em.close();
	}

	@AfterAll
	void closeFactory() {
		emf.close();
	}

	@Test
	void testOneToOnePersist() {
		Profile p = new Profile();
		p.setPhone("99999");
		p.setAddress("Delhi");
		User u = new User();
		u.setName("Yusuf");
		u.setEmail("yusuf@test.com");
		u.setProfile(p);
		service.registerUser(u);
		User fetched = service.fetchUser(u.getId());
		assertNotNull(fetched.getProfile());
	}
}