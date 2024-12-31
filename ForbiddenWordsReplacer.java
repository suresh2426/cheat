// Write a Java program that replaces the forbidden words with some symbols like (*, $, #)
// Example: 
// Microsoft announced its next generation Java compiler today. It uses advanced parser and special optimizer for the Microsoft JVM. 
// Words: "Java, JVM, Microsoft"

// ********* announced its next generation **** compiler today. It uses advanced parser and special optimizer for the ********* ***.

import java.util.*;

public class ForbiddenWordsReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text:");
        String inputText = scanner.nextLine();

        System.out.println("Enter the forbidden words separated by commas:");
        String forbiddenWordsInput = scanner.nextLine();

        String[] forbiddenWords = forbiddenWordsInput.split("\\s*,\\s*");

        String outputText = replaceForbiddenWords(inputText, forbiddenWords);
        
        System.out.println("Modified text:");
        System.out.println(outputText);

        scanner.close();
    }

    private static String replaceForbiddenWords(String text, String[] forbiddenWords) {
        for (String word : forbiddenWords) {
            String replacement = "*".repeat(word.length());
            text = text.replaceAll("(?i)\\b" + word + "\\b", replacement);
        }
        return text; 
    }
}
