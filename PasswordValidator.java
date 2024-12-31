// Some websites impose certain rules for passwords. Write a method that checks whether a string is a vaild password. Suppose the password rule is as follows:
// a. A password must have at least eight characters.
// b. A password consists of only letters and digits.
// c. A password must contain at least two digits.
// Write a Java program that prompts the user to enter a password and displays "Vaild Password" if the rule is followed or "Invalid Password" otherwise.

import java.util.*;

public class PasswordValidator {
    
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        return digitCount >= 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        if (isValidPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
        
        scanner.close();
    }
}
