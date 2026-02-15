package com.practice;
import javax.persistence.*;
public class Main2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Student student = em.find(Student.class, 105);
		if (student != null) {
			College college = student.getCollege();
			if (college != null) {
				college.getStudent().remove(student);
			}
			em.remove(student);
			System.out.println("Student deleted successfully.");
		} else {
			System.out.println("Student does not exist.");
		}
		et.commit();
	}
}