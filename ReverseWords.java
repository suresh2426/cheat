import java.util.*;

public class ReverseWords {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a list of words separated by spaces:");
 String input = scanner.nextLine();
String[] words = input.split(" ");
System.out.println("Words in reverse order:");
for (int i = words.length - 1; i >= 0; i--) {
System.out.print(words[i] + " ");
}
scanner.close();
}
}
