package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MedicalRecordDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveMedicalRecord(MedicalRecord m) {

		if (m != null) {
			et.begin();
			em.persist(m);
			et.commit();
		} else {
			System.out.println("Medical record is null");
		}
	}

	public MedicalRecord findMedicalRecord(int id) {

		return em.find(MedicalRecord.class, id);
	}

	public void updateMedicalRecord(MedicalRecord m) {

		if (m != null) {
			et.begin();
			em.merge(m);
			et.commit();
		}
	}

	public void deleteMedicalRecord(int id) {

		MedicalRecord m = em.find(MedicalRecord.class, id);

		if (m != null) {
			et.begin();
			em.remove(m);
			et.commit();
		}
	}
}
