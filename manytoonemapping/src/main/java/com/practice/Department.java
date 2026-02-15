package com.practice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	private int id;
	private String name;
	private String manager_name;
	private int no_of_employee;
	@ManyToOne
	private List<Employee> employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public int getNo_of_employee() {
		return no_of_employee;
	}

	public void setNo_of_employee(int no_of_employee) {
		this.no_of_employee = no_of_employee;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager_name=" + manager_name + ", no_of_employee="
				+ no_of_employee + "]";
	}

}
