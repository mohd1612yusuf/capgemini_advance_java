package com.capgemini.springbootbasic;

import java.util.List;

public class College {
	public String name;
	public String location;
	public List<Student> student;

	@Override
	public String toString() {
		return "College [name=" + name + ", location=" + location + ", student=" + student + "]";
	}
}
