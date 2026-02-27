package com.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
//		Person person = ioc.getBean("person", Person.class);
//		System.out.println(person);
//		person.message();

//		Employee e = ioc.getBean("employee", Employee.class);
//		System.out.println(e);

//		Employee e = ioc.getBean(Employee.class);
//		System.out.println(e);
//		System.out.println(e.getId());
//		System.out.println(e.getName());
//		System.out.println(e.getSalary());
//		Person person = ioc.getBean(Person.class);
//		System.out.println(person);
//		System.out.println(person.getMobile());
//		System.out.println(ioc.getBean(Mobile.class));
//		System.out.println(person.getScan());

		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		AnnotationConfigApplicationContext ac = (AnnotationConfigApplicationContext) ioc;
	}
}