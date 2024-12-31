import java.util.*;

public class StringPadding {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a string (max 20 characters):");
String input = scanner.nextLine();

if (input.length() > 20) {
System.out.println("Input exceeds 20 characters. Please try again.");
} else {
StringBuilder paddedString = new StringBuilder(input);
while (paddedString.length() < 20) {
paddedString.append('*');
}
System.out.println("Padded String: " + paddedString.toString());
}
scanner.close();
}
}
