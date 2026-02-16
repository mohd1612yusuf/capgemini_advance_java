package com.capgemini;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppointmentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveAppointment(Appointment a) {
		et.begin();
		em.persist(a);
		et.commit();
	}

	public List<Appointment> findAppointmentByDoctor(Long id) {
		Doctor d = em.find(Doctor.class, id);

		if (d != null) {
			return d.getList();
		}
		return null;

	}

	public void updateFee(Long id, double newFee) {
		Appointment a = em.find(Appointment.class, id);

		if (a != null) {
			et.begin();
			a.setFees(newFee);
			et.commit();
		}
	}

	public Appointment findAppointment(Long id) {
		return em.find(Appointment.class, id);
	}

}
