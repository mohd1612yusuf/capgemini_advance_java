package com.prac;

public class Demo {
	public static void main(String[] args) {
		Predicate<Integer> obj1 = i -> i > 18;
		System.out.println(obj1.test(10));
		Employee employee = new Employee(101, "Arjun Kumar", 28, "Male", "IT", "Software Engineer", 55000, "Chennai",
				"arjun.kumar@gmail.com", "9876543210");
		Predicate<Employee> check = e.getGender().equals("Male");
		System.out.println(check.test(employee));
	}
}
