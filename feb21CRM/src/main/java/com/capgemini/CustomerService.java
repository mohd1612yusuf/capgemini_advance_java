package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerService {

	private EntityManager em;

	public CustomerService(EntityManager em) {
		this.em = em;
	}

	public void registerCustomer(String name, String email, String phone) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Customer customer = new Customer();
			customer.setName(name);
			customer.setEmail(email);
			customer.setPhone(phone);

			em.persist(customer);

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
		}
	}

	public void addAddressToCustomer(Long customerId, Address address) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Customer customer = em.find(Customer.class, customerId);
			customer.setAddress(address);

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
		}
	}
}