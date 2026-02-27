package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DoctorToAppointmentService {

	private EntityManager em;

	public DoctorToAppointmentService(EntityManager em) {
		this.em = em;
	}

	public void createDoctorWithAppointment(Doctor d) {
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(d); // only doctor because we have cascade
		et.commit();

	}

	public void getDoctorWithAppointment(long d_id) {
		Appointment a = em.find(Appointment.class, d_id); // we cannot get the doctor because this is uni directional
	}

	public void updateScheduleOfAppointment(long d_id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Doctor d = em.find(Doctor.class, d_id);

		for (Appointment a : d.getAppointments()) {
			if (a.getStatus().equalsIgnoreCase("SCHEDULED")) {
				a.setStatus("COMPLETED");
				break;
			}
		}
		et.commit();

	}

}