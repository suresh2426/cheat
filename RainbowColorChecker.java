// Define a class with methods 'DisplayColor' which takes one character as argument. Raise an error if the character is not an alphabet. If the alphabet is a color of the rainbow, display the color name. If it is any other alphabet, repeat an error.

import java.util.Scanner;

// Custom Exception for Invalid Characters
class InvalidCharacterException extends Exception {
  public InvalidCharacterException(String message) {
      super(message);
  }
}

// Custom Exception for Invalid Alphabet (Not a Rainbow Color)
class NotARainbowColorException extends Exception {
  public NotARainbowColorException(String message) {
      super(message);
  }
}

// Class for Color Validation
class ColorChecker {

  // Method to Display the Rainbow Color
  public void displayColor(char alphabet) throws InvalidCharacterException, NotARainbowColorException {
      // Validate if the input is an alphabet
      if (!Character.isAlphabetic(alphabet)) {
          throw new InvalidCharacterException("Error: Input must be an alphabet.");
      }

      // Convert the character to lowercase for case-insensitive comparison
      alphabet = Character.toLowerCase(alphabet);

      // Check if it corresponds to a rainbow color
      switch (alphabet) {
          case 'v':
              System.out.println("Violet");
              break;
          case 'i':
              System.out.println("Indigo");
              break;
          case 'b':
              System.out.println("Blue");
              break;
          case 'g':
              System.out.println("Green");
              break;
          case 'y':
              System.out.println("Yellow");
              break;
          case 'o':
              System.out.println("Orange");
              break;
          case 'r':
              System.out.println("Red");
              break;
          default:
              throw new NotARainbowColorException("Error: The alphabet does not represent a rainbow color.");
      }
  }
}

// Main Class
public class RainbowColorChecker {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);  // Scanner for taking input from the user
      ColorChecker checker = new ColorChecker();

      try {
          // Prompt user for input
          System.out.print("Enter a character: ");
          char input = scanner.next().charAt(0);  // Read the first character entered by the user
          
          // Call the displayColor method with the user input
          checker.displayColor(input);
      } catch (InvalidCharacterException | NotARainbowColorException e) {
          System.out.println(e.getMessage());
      } finally {
          scanner.close();  // Close the scanner to prevent resource leak
      }
  }
}
