package com.capgemini;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College c = new College();
		c.setId(1);
		c.setEname("nani");
		c.setPincode("kvl");

		Student s1 = new Student(101, "nani", "CSE");

		Student s2 = new Student();
		s2.setId(102);
		s2.setEname("Kiran");
		s2.setBranch("ECE");

		s1.setCollege(c);
		s2.setCollege(c);

		c.setStudent(Arrays.asList(s1, s2));

		et.begin();
		em.persist(c);
		et.commit();

	}

}