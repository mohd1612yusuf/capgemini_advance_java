package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PatientToMedicalRecordService {
	private EntityManager em;

	public PatientToMedicalRecordService(EntityManager em) {
		this.em = em;
	}

	public void createMedicalRecord(Patient p, MedicalRecord mr) {
		EntityTransaction et = em.getTransaction();
		p.setMedicalRecord(mr);
		et.begin();
		em.persist(p);
		et.commit();
	}

	public void getPatientById(long id) {
		Patient p = em.find(Patient.class, id);
		if (p != null && p.getMedicalRecord() != null) {
			System.out.println(p.getMedicalRecord().getDiagnosis());
		}
	}

	public void updatePatientMedicalRecords(long id, String newNotes) {
		EntityTransaction et = em.getTransaction();
		Patient p = em.find(Patient.class, id);
		et.begin();
		if (p != null && p.getMedicalRecord() != null) {
			p.getMedicalRecord().setNotes(newNotes);
		}
		et.commit();
	}

	public void deletePatient(long id) {
		EntityTransaction et = em.getTransaction();
		Patient p = em.find(Patient.class, id);
		et.begin();
		if (p != null)
			em.remove(p);
		et.commit();
	}
}