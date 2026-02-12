package com.prac;

public class Employee {
	int id;
	String name;
	int age;
	String branch;

	public Employee(int id, String name, int age, String branch) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
	}

	public boolean isValidAge() {
		if (age > 17) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidName() {
		if (name.length() <= 1) {
			return false;
		} else if (name == null) {
			return false;
		} else {
			return name.matches("[A-Za-z]+");
		}
	}
}
