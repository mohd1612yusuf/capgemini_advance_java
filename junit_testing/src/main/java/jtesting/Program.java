package jtesting;

public class Program {
	public boolean isPalindrome(String str) {
		StringBuilder s = new StringBuilder(str);
		return (s.reverse().toString().equals(str)) ? true : false;
	}

	public int add(int a, int b) {
		return a + b;
	}
}
