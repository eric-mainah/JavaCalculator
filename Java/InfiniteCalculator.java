import java.util.Scanner;

public class InfiniteCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        // Continuously prompt the user for input until they enter "quit"
        while (true) {
            System.out.print("Enter a number or an operator (+, -, *, /): ");
            String input = scanner.next();

            // Exit the loop if the user enters "quit"
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            // Parse the input as a number or an operator
            try {
                double value = Double.parseDouble(input);
                // If the input is a number, add it to the result using the "+" operator
                result = performOperation(result, value, '+');
            } catch (NumberFormatException e) {
                // If the input is an operator, perform the corresponding operation
                char operator = input.charAt(0);
                result = performOperation(result, 0, operator);
            }

            System.out.println("Result: " + result);
        }
    }

    // Perform the operation specified by the operator on the left and right operands
    public static double performOperation(double leftOperand, double rightOperand, char operator) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                return leftOperand / rightOperand;
            default:
                // If an invalid operator is entered, return the left operand as is
                System.out.println("Invalid operator");
                return leftOperand;
        }
    }
}
