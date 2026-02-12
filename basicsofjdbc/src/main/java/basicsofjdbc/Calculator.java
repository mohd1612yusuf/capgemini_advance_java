package basicsofjdbc;

public class Calculator {

	public static int add(int a, int b) {
		return a + b;
	}

	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static boolean isPalindrome(String s) {
		String rev = reverseString(s);
		return s.equalsIgnoreCase(rev);
	}

	public static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	public static int div(int a, int b) {
		return a/b;
	}
}
