package expressivo;


/**
 * A utility class to calculate the sum of the digits of a number using recursion.
 */
public class recursiveSOD {
	/**
     * Computes the sum of digits of a given number using recursion.
     *
     * @param number the integer whose sum of digits needs to be computed.
     *               Handles both positive and negative integers.
     * @return the sum of the digits as an integer.
     *         If the input is 0, the result is 0.
     */
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting them to positive
        number = Math.abs(number);

        // Base case: if number is 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add the last digit to the sum of remaining digits
        return (number % 10) + sumOfDigits(number / 10);
    }
}
