package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

//			String jpql = "select p from Product p where p.price >= ?1 and p.quantity >= ?2";
//
//			Query query = em.createQuery(jpql);
//			query.setParameter(1, 15);
//			query.setParameter(2, 20);
//
//			List<Product> list = query.getResultList();
//
//			for (Product p : list) {
//				System.out.println(p);
//			}

//			String jpql = "Update Product p set p.price=?1 where p.price=?2";
//			et.begin();
//			Query query = em.createQuery(jpql);
//			query.setParameter(1, 80);
//			query.setParameter(2, 100);
//			query.executeUpdate();
//			et.commit();
//			em.close();
//			emf.close();

//			String sql="select * from Product";
//			Query query = em.createNativeQuery(sql);
//			List<Product> list = query.getResultList();
//			System.out.println(list);

//			String sql = "update Product set price=?1 where price>=?2";
//			et.begin();
//			Query query = em.createNativeQuery(sql);
//			query.setParameter(1, 15.0);
//			query.setParameter(2, 10.0);
//			query.executeUpdate();
//			et.commit();
			
			String jpql="select p from Product p where p.price>=:a and p.quantity>=:b";
			Query query=em.createQuery(jpql);
			query.setParameter("a", 10);
			query.setParameter("b", 15);
			List<Product> list=query.getResultList();
			for(Product p:list) {
				System.out.println(p);
			}

		} finally {
			em.close();
			emf.close();
		}
	}
}
