package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProfileDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveProfile(Profile p) {

		et.begin();
		em.persist(p);
		et.commit();
	}
}
