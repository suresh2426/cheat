// Define Exceptions: VowelException, BlankException, ExitException.
// Write another class Test which reads a character from command line. If it is a vowel, throw VowelException, if it is blank throw BlankException and for a character 'X' throw an ExitException and terminate program.
// For any other character, display 'Valid character'.

// Exception for vowels
class VowelException extends Exception {
  public VowelException(String message) {
      super(message);
  }
}

// Exception for blank input
class BlankException extends Exception {
  public BlankException(String message) {
      super(message);
  }
}

// Exception for 'X' input
class ExitException extends Exception {
  public ExitException(String message) {
      super(message);
  }
}

// Main class to test the functionality
public class TestCharacter {
  public static void main(String[] args) {
      try {
          // Check if a character is passed as input
          if (args.length < 1) {
              throw new BlankException("Error: No input provided. Please enter a character.");
          }

          // Get the input character
          String input = args[0].trim();

          // Check for blank input
          if (input.isEmpty()) {
              throw new BlankException("Error: Input cannot be blank.");
          }

          // Ensure the input is a single character
          if (input.length() != 1) {
              throw new IllegalArgumentException("Error: Please enter only one character.");
          }

          char ch = input.charAt(0); // Get the first character

          // Check if the character is a vowel
          if ("aeiouAEIOU".indexOf(ch) != -1) {
              throw new VowelException("Error: Vowel detected.");
          }

          // Check if the character is 'X' (case insensitive)
          if (ch == 'X' || ch == 'x') {
              throw new ExitException("Exiting program as 'X' was entered.");
          }

          // If no exceptions are thrown, the character is valid
          System.out.println("Valid character: " + ch);

      } catch (VowelException | BlankException | ExitException e) {
          // Handle custom exceptions
          System.out.println(e.getMessage());

          // Terminate program if ExitException is thrown
          if (e instanceof ExitException) {
              System.exit(0);
          }
      } catch (IllegalArgumentException e) {
          // Handle invalid inputs
          System.out.println(e.getMessage());
      }
  }
}
