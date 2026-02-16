package com.capgemini;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private int id;

	private String name;
	private String manager_name;
	private int no_of_employee;

	@ManyToMany(mappedBy = "departments")
	private List<Employee> employees;

	public Department() {
	}

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
