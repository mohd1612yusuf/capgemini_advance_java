package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entity.Payment;

public class PaymentDAO {
	private EntityManager em;
	public PaymentDAO(EntityManager em) {
		this.em = em;
	}
	public void savePayment(Payment p) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	}
	public Payment findPayment(Long id) {
		return em.find(Payment.class, id);
	}
}