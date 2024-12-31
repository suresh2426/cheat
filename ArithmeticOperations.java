// Write a program which accepts two integers and an arithmetic operator from the command line and performs the operations. Fire the following user defined exceptions:
// a) If the no. of arguments are less than 3 than fire 'IllegalNumberOfArguments'
// b) If the operator is not an arithmetic operator, throw 'InvaliOperatorException'
// c) If result is negative then throw 'NegativeResultException'.


// Exception for insufficient arguments
class IllegalNumberOfArgumentsException extends Exception {
  public IllegalNumberOfArgumentsException(String message) {
      super(message);
  }
}

// Exception for invalid operators
class InvalidOperatorException extends Exception {
  public InvalidOperatorException(String message) {
      super(message);
  }
}

// Exception for negative results
class NegativeResultException extends Exception {
  public NegativeResultException(String message) {
      super(message);
  }
}

// Main class for arithmetic operations
public class ArithmeticOperations {
  public static void main(String[] args) {
      try {
          // Check if the number of arguments is valid
          if (args.length < 3) {
              throw new IllegalNumberOfArgumentsException("Error: Exactly 3 arguments are required: operand1 operand2 operator.");
          }

          // Parse the operands
          int num1 = Integer.parseInt(args[0]);
          int num2 = Integer.parseInt(args[1]);
          char operator = args[2].charAt(0);

          // Perform the operation and calculate the result
          int result = performOperation(num1, num2, operator);

          // Check if the result is negative
          if (result < 0) {
              throw new NegativeResultException("Error: The result of the operation is negative.");
          }

          // Display the result
          System.out.println("Result: " + result);

      } catch (IllegalNumberOfArgumentsException | InvalidOperatorException | NegativeResultException e) {
          System.out.println(e.getMessage());
      } catch (NumberFormatException e) {
          System.out.println("Error: Please provide valid integers for the operands.");
      }
  }

  // Method to perform the arithmetic operation
  private static int performOperation(int num1, int num2, char operator)
          throws InvalidOperatorException {
      switch (operator) {
          case '+':
              return num1 + num2;
          case '-':
              return num1 - num2;
          case '*':
              return num1 * num2;
          case '/':
              if (num2 == 0) {
                  throw new InvalidOperatorException("Error: Division by zero is not allowed.");
              }
              return num1 / num2;
          default:
              throw new InvalidOperatorException("Error: Invalid operator. Supported operators are +, -, *, /.");
      }
  }
}
