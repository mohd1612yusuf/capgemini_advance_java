package com.practice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	private int id;
	private String ename;
	private String branch;

	public Student(int id, String ename, String branch) {
		super();
		this.id = id;
		this.ename = ename;
		this.branch = branch;
	}

	public Student() {}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", ename=" + ename + ", branch=" + branch + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
