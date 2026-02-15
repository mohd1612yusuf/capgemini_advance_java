package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entity.PurchaseOrder;

public class OrderDAO {
	private EntityManager em;
	public OrderDAO(EntityManager em) {
		this.em = em;
	}
	public void saveOrder(PurchaseOrder o) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(o);
		tx.commit();
	}
	public PurchaseOrder findOrder(Long id) {
		return em.find(PurchaseOrder.class, id);
	}
	public List<PurchaseOrder> findOrdersByUser(Long userId) {
		return em.createQuery("SELECT u.orders FROM User u WHERE u.id = :id", PurchaseOrder.class)
				.setParameter("id", userId).getResultList();
	}
}