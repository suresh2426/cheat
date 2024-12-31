// Write a java program to read a text from the console. It will count all occurrences of that word. Replace all occurrences of that word with other word (Find and Replace function).

import java.util.*;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph of text:");
        String paragraph = scanner.nextLine();

        System.out.println("Enter the word to find:");
        String wordToFind = scanner.nextLine();

        System.out.println("Enter the word to replace with:");
        String replacementWord = scanner.nextLine();

        int count = 0;
        String[] words = paragraph.split("\\s+"); 

        for (String word : words) {
            if (word.equalsIgnoreCase(wordToFind)) {
                count++;
            }
        }

        String replacedParagraph = paragraph.replaceAll("(?i)\\b" + wordToFind + "\\b", replacementWord); 

        System.out.println("Number of occurrences of '" + wordToFind + "': " + count);
        System.out.println("Modified paragraph:");
        System.out.println(replacedParagraph);

        scanner.close();
    }
}
