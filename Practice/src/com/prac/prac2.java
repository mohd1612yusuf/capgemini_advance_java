package com.prac;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class prac2 {
	public static void main(String[] args) {
		String s = "Hello";
//		Map<Object, Long> res = s.chars().mapToObj(i -> (char) i)
//				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//		System.out.println(res);
		
		List<Employee> employee = prac1.getEmployee();
		Map<String, Long> deptCount = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new ,Collectors.counting()));
		System.out.println(deptCount);
		
//		for (Map.Entry<Object, Long> map : res.entrySet()) {
//			System.out.println(map.getKey() + " " + map.getValue());
//		}
//		System.out.println(res);
	}
}
