package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UsersDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	public void insertUsers() {
		EntityTransaction et = em.getTransaction();
		Users user = new Users();
		user.setId(1);
		user.setName("Allen");
		user.setBalance(2000);
		et.begin();
		em.persist(user);
		et.commit();
	}
}
