package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ProductDao {

	public static void addProducts(EntityTransaction et, EntityManager em) {

		Product p = new Product(1, "Oil", 3, 1000);

		et.begin();
		em.persist(p);
		et.commit();
	}

	public static void updateProducts(EntityTransaction et, EntityManager em) {

		Product product = em.find(Product.class, 1);

		if (product != null) {
			et.begin(); // BEGIN FIRST
			product.setName("hero");
			em.merge(product);
			et.commit();
		}
	}

	public static void deleteProducts(EntityTransaction et, EntityManager em) {

		Product p = em.find(Product.class, 1);

		if (p != null) {
			et.begin();
			em.remove(p);
			et.commit();
		}
	}

	public static void findById(EntityManager em) {

		Product p = em.find(Product.class, 1);

		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("Product not found");
		}
	}

	public static void findAllProduct(EntityManager em) {

		String jpql = "select p from Product p";
		Query query = em.createQuery(jpql);

		List<Product> list = query.getResultList();
		list.forEach(System.out::println);
	}
}
