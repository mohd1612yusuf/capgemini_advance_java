package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	// Insert Product
	public void insertData(Product p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(p);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw e; // rethrow for test coverage
		} finally {
			em.close();
		}
	}

	// Find Product by ID
	public Product findById(int id) {

		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Product.class, id);
		} finally {
			em.close();
		}
	}

	// Close factory (for test cleanup)
	public static void closeFactory() {
		if (emf.isOpen()) {
			emf.close();
		}
	}
}
