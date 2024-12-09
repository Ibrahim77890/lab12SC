package expressivo;

import static org.junit.Assert.*;

import org.junit.*;

public class recursiveSODTest {
	@Test
    public void testSumOfDigitsPositiveNumber() {
        assertEquals(6, recursiveSOD.sumOfDigits(123)); // 1 + 2 + 3 = 6
    }

    @Test
    public void testSumOfDigitsNegativeNumber() {
        assertEquals(15, recursiveSOD.sumOfDigits(-456)); // |(-4) + (-5) + (-6)| = 15
    }

    @Test
    public void testSumOfDigitsZero() {
        assertEquals(0, recursiveSOD.sumOfDigits(0)); // Sum of digits of 0 is 0
    }

    @Test
    public void testSumOfDigitsLargeNumber() {
        assertEquals(45, recursiveSOD.sumOfDigits(123456789)); // 1+2+3+4+5+6+7+8+9 = 45
    }

    @Test
    public void testSumOfDigitsSingleDigit() {
        assertEquals(7, recursiveSOD.sumOfDigits(7)); // Single digit remains the same
    }
}
