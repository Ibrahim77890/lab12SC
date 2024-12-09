package expressivo;

import java.util.*;

/**
 * A utility class to evaluate mathematical expressions.
 * Supports operators +, -, *, / and handles parentheses.
 */
public class recursiveExpressionParser {

    /**
     * Evaluates a given mathematical expression.
     *
     * @param expression the mathematical expression as a string. 
     *                   It can include numbers, operators (+, -, *, /), and parentheses.
     *                   Spaces within the expression are ignored.
     *                   Example: "3 + 5 * (2 - 8)".
     * @return the result of the evaluated expression as a double. 
     *         If the expression is empty or null, it returns 0.0.
     * @throws IllegalArgumentException if the expression is malformed.
     * @throws ArithmeticException if there is a division by zero.
     */
    public static double evaluateExpression(String expression) {
        // Check if the expression is empty
        if (expression == null || expression.trim().isEmpty()) {
            return 0.0;
        }

        expression = expression.replaceAll("\\s", ""); // Remove spaces
        return evaluateExpressionWithStack(expression);
    }

    /**
     * Core method to evaluate a mathematical expression using stacks.
     *
     * @param expression the mathematical expression without spaces.
     * @return the evaluated result of the expression as a double.
     */
    private static double evaluateExpressionWithStack(String expression) {
        if (expression.isEmpty()) {
            return 0.0;
        }

        Stack<Double> operands = new Stack<>();  // Stack to store numbers
        Stack<Character> operators = new Stack<>(); // Stack to store operators
        
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // If the character is a digit, parse the number
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                operands.push(Double.parseDouble(sb.toString()));
            }
            // If the character is '(', push it to operators stack
            else if (ch == '(') {
                operators.push(ch);
                i++;
            }
            // If the character is ')', evaluate the expression inside the parentheses
            else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateTopOperator(operands, operators);
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop(); // Pop the '('
                }
                i++;
            }
            // If the character is an operator
            else if (isOperator(ch)) {
                // Process the operators on the stack based on precedence
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    evaluateTopOperator(operands, operators);
                }
                operators.push(ch);
                i++;
            }
        }
        
        // Evaluate the remaining operators in the stack
        while (!operators.isEmpty()) {
            evaluateTopOperator(operands, operators);
        }

        return operands.pop(); // The final result is the last operand
    }

    /**
     * Evaluates the top operator in the operator stack with the two top operands in the operand stack.
     *
     * @param operands the stack of operands (numbers).
     * @param operators the stack of operators.
     * @throws ArithmeticException if there is a division by zero.
     * @throws IllegalArgumentException if an unknown operator is encountered.
     */
    private static void evaluateTopOperator(Stack<Double> operands, Stack<Character> operators) {
        double right = operands.pop();
        double left = operands.pop();
        char operator = operators.pop();

        switch (operator) {
            case '+':
                operands.push(left + right);
                break;
            case '-':
                operands.push(left - right);
                break;
            case '*':
                operands.push(left * right);
                break;
            case '/':
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                operands.push(left / right);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    /**
     * Checks if the given character is a mathematical operator.
     *
     * @param c the character to check.
     * @return true if the character is one of +, -, *, /, false otherwise.
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Returns the precedence of a mathematical operator.
     *
     * @param operator the operator character.
     * @return an integer representing precedence (higher number means higher precedence).
     *         Returns -1 for unrecognized operators.
     */
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1; // Lower precedence
            case '*':
            case '/':
                return 2; // Higher precedence
            default:
                return -1;
        }
    }

}
