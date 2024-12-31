import palindromechecker.PalindromeChecker;

import java.util.Scanner;

public class PalindromeTester {

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        if (checker.isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
        
        scanner.close();
    }
}
