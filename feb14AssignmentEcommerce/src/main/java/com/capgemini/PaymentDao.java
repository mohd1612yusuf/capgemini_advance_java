package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PaymentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void savePayment(Payment p) {
		if (p != null) {
			et.begin();
			em.persist(p);
			et.commit();
		} else {
			System.out.println("null");
		}
	}

	public Payment findPayment(Long id) {
		return em.find(Payment.class, id);

	}

}
