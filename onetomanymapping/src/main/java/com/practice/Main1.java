package com.practice;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class Main1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		College college = em.find(College.class, 1);

		if (college == null) {
			college = new College();
			college.setId(1);
			college.setEname("LPU");
			college.setLocation("Punjab");
			college.setPincode("144411");
		}

		Student student = em.find(Student.class, 103);

		if (student != null) {
			student.setEname("Annie");
			student.setBranch("ME");
			System.out.println("Student updated.");
		} else {
			student = new Student();
			student.setId(103);
			student.setEname("Annie");
			student.setBranch("ME");

			student.setCollege(college);

			List<Student> list = college.getStudent();
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(student);
			college.setStudent(list);

			em.persist(college);

			System.out.println("Student inserted with relation.");
		}

		et.commit();

	}
}
