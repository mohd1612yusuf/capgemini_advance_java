package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.practice.Calculator;

public class CalculatorTest {

	@Test
	public void divideTest() {
		Calculator c = new Calculator();
		int actualRes = c.divide(10, 2);
		assertEquals(5, actualRes);
	}

	@Test
	public void divideTestZero() {
		Calculator c = new Calculator();
		assertThrows(ArithmeticException.class, () -> {
			c.divide(10, 0);
		});
	}
}
