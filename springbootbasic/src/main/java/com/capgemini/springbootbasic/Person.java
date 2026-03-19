package com.capgemini.springbootbasic;

import java.util.List;

public class Person {
	public int id;
	public String name;
	public List<String> item;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", item=" + item + "]";
	}

}
