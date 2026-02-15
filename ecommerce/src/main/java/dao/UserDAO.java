package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entity.User;

public class UserDAO {
	private EntityManager em;

	public UserDAO(EntityManager em) {
		this.em = em;
	}

	public void saveUser(User u) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
	}

	public User findUser(Long id) {
		return em.find(User.class, id);
	}

	public void updateUser(User u) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(u);
		tx.commit();
	}

	public void deleteUser(Long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User u = em.find(User.class, id);
		if (u != null)
			em.remove(u);
		tx.commit();
	}
}