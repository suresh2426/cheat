// Write a java program to read a paragraph of text from the console and print the number of vowels and the position of vowel, number of characters, number of lines and number of sentences by using String buffer and String tokenizer. 

import java.util.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a paragraph of text (Double Enter to get the output): ");
        StringBuffer paragraph = new StringBuffer();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {  
                break;
            }
            paragraph.append(line).append("\n");
        }

        int vowelCount = 0;
        StringBuffer vowelPositions = new StringBuffer();
        int characterCount = paragraph.length();
        int lineCount = 0;
        int sentenceCount = 0;
        
        String vowels = "aeiouAEIOU";

        StringTokenizer lineTokenizer = new StringTokenizer(paragraph.toString(), "\n");
        while (lineTokenizer.hasMoreTokens()) {
            String line = lineTokenizer.nextToken();
            lineCount++;

            StringTokenizer sentenceTokenizer = new StringTokenizer(line, ".!?");
            sentenceCount += sentenceTokenizer.countTokens();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                
                if (vowels.indexOf(ch) != -1) {
                    vowelCount++;
                    vowelPositions.append((i + 1) + " ");  
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Positions of vowels: " + vowelPositions.toString());
        System.out.println("Number of characters: " + characterCount);
        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of sentences: " + sentenceCount);
        
        scanner.close();
    }
}


