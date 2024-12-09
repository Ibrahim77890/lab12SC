package expressivo;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Unit tests for the recursiveExpressionParser class.
 */
public class recursiveExpressionParserTest {

    @Test
    public void testBasicAddition() {
        String expression = "2 + 3";
        double expected = 5.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testBasicSubtraction() {
        String expression = "5 - 3";
        double expected = 2.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testBasicMultiplication() {
        String expression = "4 * 2";
        double expected = 8.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testBasicDivision() {
        String expression = "8 / 4";
        double expected = 2.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testOperatorPrecedence() {
        String expression = "2 + 3 * 4";
        double expected = 14.0; // 2 + (3 * 4)
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testParentheses() {
        String expression = "(2 + 3) * 4";
        double expected = 20.0; // (2 + 3) * 4
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testNestedParentheses() {
        String expression = "2 + (3 * (2 + 1))";
        double expected = 11.0; // 2 + (3 * (2 + 1))
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        String expression = "8 / 0";
        assertThrows(ArithmeticException.class, () -> recursiveExpressionParser.evaluateExpression(expression));
    }

    @Test
    public void testEmptyExpression() {
        String expression = "";
        double expected = 0.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testNullExpression() {
        String expression = null;
        double expected = 0.0;
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testDecimalNumbers() {
        String expression = "3.5 + 2.2";
        double expected = 5.7; // 3.5 + 2.2
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }

    @Test
    public void testComplexExpression() {
        String expression = "3 + 5 * (2 - 8)";
        double expected = -27.0; // 3 + 5 * (2 - 8)
        assertEquals(expected, recursiveExpressionParser.evaluateExpression(expression), 0.0001);
    }
}