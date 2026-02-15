package com.practice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s1=new Student();
		s1.setId(101);
		s1.setBranch("CSE");
		s1.setEname("Rohit");
		
		Student s2=new Student();
		s2.setId(102);
		s2.setBranch("ECE");
		s2.setEname("Miller");
		
		College c=new College();
		c.setId(1);
		c.setEname("ABC");
		c.setLocation("Delhi");
		c.setPincode("0001");
		
		List<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		
		c.setStudent(list);
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
}
