package com.capgemini;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Yusuf");
		e1.setSalary(50000);
		e1.setDesignation("Developer");

		Department d1 = new Department();
		d1.setId(101);
		d1.setName("IT");
		d1.setManager_name("Rahul");
		d1.setNo_of_employee(10);

		Department d2 = new Department();
		d2.setId(102);
		d2.setName("HR");
		d2.setManager_name("Neha");
		d2.setNo_of_employee(5);

		e1.setDepartments(Arrays.asList(d1, d2));
		em.persist(d1);
		em.persist(d2);
		em.persist(e1);
		et.commit();
	}
}
