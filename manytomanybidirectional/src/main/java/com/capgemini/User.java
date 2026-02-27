package com.capgemini;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.security.auth.Subject;

public class User {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Miller");
		student1.setBranch("CSE");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Rohit");
		student2.setBranch("ECE");

		Subject sub1 = new Subject();
		sub1.setId(100);
		sub1.setName("Micro-processor");

		Subject sub2 = new Subject();
		sub2.setId(101);
		sub2.setName("Machine learning");

		Subject sub3 = new Subject();
		sub3.setId(102);
		sub3.setName("Software Engineering");

		List<Student> stu = List.of(student1, student2);
		List<Student> subject = List.of(sub1, sub2, sub3);
		
		student1.setSubject(subject);
		student2.setSubject(subject);
		
		sub1.setStudent(stu);
		sub2.setStudent(stu);
		sub3.setStudent(stu);
		
		et.begin();
		em.persist(student2);
		em.persist(student1);
		et.commit();
	}

}