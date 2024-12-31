// Write a JAVA program that figures out whether one string is an anagram of another string. An anagram is a word or a phrase made by transposing the letters of another word or phrase; for example, "parliament" is an anagram of "partial men", and "software" is an anagram of "swear oft". The program should ignore white space and punctuation.

import java.util.*;

public class AnagramChecker {

    private static char[] cleanAndSort(String str) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                cleaned.append(Character.toLowerCase(c)); 
            }
        }

        char[] charArray = cleaned.toString().toCharArray();
        Arrays.sort(charArray);
        return charArray; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            System.out.println("Enter the first string (or type 'exit' to quit):");
            String str1 = scanner.nextLine();

            if (str1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            System.out.println("Enter the second string:");
            String str2 = scanner.nextLine();

            char[] sortedStr1 = cleanAndSort(str1);
            char[] sortedStr2 = cleanAndSort(str2);

            if (Arrays.equals(sortedStr1, sortedStr2)) {
                System.out.println("\"" + str1 + "\" is an anagram of \"" + str2 + "\".");
            } else {
                System.out.println("\"" + str1 + "\" is not an anagram of \"" + str2 + "\".");
            }
        }

        scanner.close();
    }
}
