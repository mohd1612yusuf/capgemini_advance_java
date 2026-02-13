package com.onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	public static void main(String[] args) {
//		inserCarAndEngine();
//		findByCarId();
		deleteByEngineId();
	}

	public static void deleteByEngineId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query updateQuery = em.createNativeQuery("Update car set engine_id=null where engine_id=?1");
		updateQuery.setParameter(1, 100);
		Query deleteQuery = em.createNativeQuery("Delete from engine where id=?1");
		deleteQuery.setParameter(1, 100);
		updateQuery.executeUpdate();
		deleteQuery.executeUpdate();
		et.commit();
	}

	public static void findByCarId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Car c = em.find(Car.class, 1);
		System.out.println(c);
		System.out.println(c.getEngine().getCc());
	}

	public static void inserCarAndEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Engine e = new Engine();
		e.setId(100);
		e.setFuelType("Petrol");
		e.setType("V8");
		e.setMileage("12");
		e.setCc("3000");
		Car c = new Car();
		c.setId(1);
		c.setBrand("Volkswagen");
		c.setModel("Polo GT10");
		c.setModelYear("2019");
		c.setPrice(1000000);
		c.setEngine(e);
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
	}
}
