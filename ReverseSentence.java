// Write a java program that asks the user for a sentence. Display the sentence backwards letter by letter.
// Example:
// Enter a sentence: Mary had a little lamb.
// Your sentence backwards: .bmal eittil a dah yraM

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Reverse the sentence and print it
        String reversedSentence = new StringBuilder(sentence).reverse().toString();
        System.out.println("Your sentence backwards: " + reversedSentence);
    }
}
