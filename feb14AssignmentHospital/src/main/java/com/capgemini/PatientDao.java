package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void savePatient(Patient p) {
		if (p != null) {
			et.begin();
			em.persist(p);
			et.commit();
		} else {
			System.out.println("null");
		}
	}

	public Patient findPatient(Long id) {
		return em.find(Patient.class, id);
	}

	public void updatePatient(Patient p) {
		et.begin();
		em.merge(p);
		et.commit();
	}

	public void deletePatient(Long id) {
		Patient p = em.find(Patient.class, id);
		et.begin();
		em.remove(p);
		et.commit();
	}
}