package com.practice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.practice.Product;

public class Demo4 {
	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = new Product();
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();
		p.setId(i);

		String n = sc.next();
		p.setName(n);

		int q = sc.nextInt();
		p.setQuantity(q);

		double pr = sc.nextDouble();
		p.setPrice(pr);

		et.begin();
		em.persist(p);
		et.commit();
	}
}
