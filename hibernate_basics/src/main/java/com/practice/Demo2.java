package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student student = em.find(Student.class, 2);
		System.out.println(student.getName());
		if(student!=null) {
			student.setDob("05-05-2000");
			et.begin();
			em.merge(student);
			et.commit();
			emf.close();
		}
	}
}
