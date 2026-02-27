package com.capgemini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDao {
	@Autowired
	private JpaUtil jpa;
	public void insert(Employee e) {
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, e.getId());
		if (employee == null) {
			em.persist(e);
		} else {
			System.out.println("Data exists");
		}
		em.getTransaction().commit();
	}
	public Employee findById(int id) {
		return jpa.getEntityManager().find(Employee.class, id);
	}
}