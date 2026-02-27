package com.capgemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CRMApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		CustomerService customerService = new CustomerService(em);
		OrderService orderService = new OrderService(em);
		ReportService reportService = new ReportService(em);

		while (true) {
			System.out.println("\n1.Register Customer");
			System.out.println("7.Place Order");
			System.out.println("9.Employee Performance");
			System.out.println("10.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				sc.nextLine();
				System.out.println("Enter name:");
				String name = sc.nextLine();
				System.out.println("Enter email:");
				String email = sc.nextLine();
				System.out.println("Enter phone:");
				String phone = sc.nextLine();
				customerService.registerCustomer(name, email, phone);
				break;

			case 7:
				System.out.println("Customer Id:");
				Long cid = sc.nextLong();
				System.out.println("Number of products:");
				int n = sc.nextInt();
				List<Long> ids = new ArrayList<>();
				for (int i = 0; i < n; i++)
					ids.add(sc.nextLong());
				orderService.placeOrder(cid, ids);
				break;

			case 9:
				System.out.println("Employee Id:");
				Long eid = sc.nextLong();
				reportService.getEmployeePerformance(eid);
				break;

			case 10:
				em.close();
				emf.close();
				sc.close();
				System.exit(0);
			}
		}
	}
}