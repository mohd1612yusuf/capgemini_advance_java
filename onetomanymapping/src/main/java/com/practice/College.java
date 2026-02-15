package com.practice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {
	@Id
	private int id;
	private String location;
	private String ename;
	private String pincode;
	@OneToMany
	private List<Student> student;

	public College(int id, String ename, String location, String pincode, List<Student> student) {
		super();
		this.id = id;
		this.ename = ename;
		this.location = location;
		this.pincode = pincode;
		this.student = student;
	}

	public College() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Student> getStudent() {
		return Student;
	}

	public void setStudent(List<Student> student) {
		Student = student;
	}

}
