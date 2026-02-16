package com.capgemini;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveOrder(PurchaseOrder o) {
		if (o != null) {
			et.begin();
			em.persist(o);
			et.commit();
		} else {
			System.out.println("not found");
		}
	}

	public PurchaseOrder findOrder(Long id) {
		PurchaseOrder po = em.find(PurchaseOrder.class, id);
		if (po != null) {
			return po;
		} else {
			return null;
		}
	}

	public void findOrderByUser(Long userId) {
		User u = em.find(User.class, userId);
		if (u != null) {
			List<PurchaseOrder> list = u.getPurchaseOrder();
			System.out.println(list);
		}
	}

}
