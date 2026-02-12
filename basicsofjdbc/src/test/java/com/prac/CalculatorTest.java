package com.prac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import basicsofjdbc.Calculator;

public class CalculatorTest {

//	@Test
	public void addTest() {
		int res = Calculator.add(20, 30);
		assertEquals(50, res);
	}

//	@Test
	public void reverseTest() {
		String actualres = Calculator.reverseString("data");
		assertEquals("atad", actualres);
	}

//	@Test
	public void reverseTestNull() {
		String actualres = Calculator.reverseString(null);
		assertEquals("llun", actualres);
	}

//	@Test
	public void palTest() {
		String s = "Madam";
		boolean check = Calculator.isPalindrome(s);
		assertEquals(true, check);
	}

//	@Test
	public void factTest() {
		int res = Calculator.factorial(5);
		assertEquals(120, res);
	}
	
//	@Test
	public void testValidAge() {
		Employee e=new Employee(10, "Allen", -17, "CSE");
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testValidName() {
		Employee e1=new Employee(10, "Henry", -17, "CSE");
		assertTrue(e1.isValidName());
	}
	
	public void testEx() {
		Calculator c=new Calculator();
		assertThrows(NullPointerException.class, ()->{c.div(10,0);});
	}
}
