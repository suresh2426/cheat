// Write a Java program that extracts from a given text all the sentences that contain given word. Example: The given word is "in".
//   The text is:
//   We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.

// The expected result is:
//   We are living in a yellow submarine. 
//   We Will move out of it in 5 days.
//    Consider that the sentences are separated by "," and the words - by non-letter symbols.

import java.util.*;

public class SentenceExtractor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        System.out.println("Enter the word to search for:");
        String searchWord = scanner.nextLine();

        StringTokenizer sentenceTokenizer = new StringTokenizer(text, ".");

        System.out.println("Sentences containing the word '" + searchWord + "':");

        while (sentenceTokenizer.hasMoreTokens()) {
            String sentence = sentenceTokenizer.nextToken().trim();

            if (containsWord(sentence, searchWord)) {
                System.out.println(sentence + ".");
            }
        }

        scanner.close();
    }

    private static boolean containsWord(String sentence, String word) {
        String[] words = sentence.split("[^a-zA-Z]+");

        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
