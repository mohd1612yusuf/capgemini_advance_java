package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveDoctor(Doctor d) {
		if (d != null) {
			et.begin();
			em.persist(d);
			et.commit();
		} else {
			System.out.println("null");
		}
	}

	public Doctor findDoctor(Long id) {
		return em.find(Doctor.class, id);
	}
}