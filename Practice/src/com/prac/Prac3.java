package com.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prac3 {
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add("apple");
		li.add("orange");
		li.add("kiwi");
		li.add("mango");
		li.add("ab");
		Map<Boolean, List<String>> res = li.stream().collect(Collectors.partitioningBy(i -> i.length() >= 3));
		System.out.println(res);
	}
}
