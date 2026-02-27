package com.capgemini;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OrderService {

	private EntityManager em;

	public OrderService(EntityManager em) {
		this.em = em;
	}

	public void placeOrder(Long customerId, List<Long> productIds) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Customer customer = em.find(Customer.class, customerId);

			Order order = new Order();
			order.setCustomer(customer);
			order.setOrderDate(LocalDate.now().toString());

			double total = 0;
			List<Product> products = new ArrayList<>();

			for (Long id : productIds) {
				Product p = em.find(Product.class, id);
				products.add(p);
				total += p.getPrice();
			}

			order.setProducts(products);
			order.setTotalAmount(total);

			em.persist(order);

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
		}
	}
}