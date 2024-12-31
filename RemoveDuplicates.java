import java.util.*;

public class RemoveDuplicates {
public static String removeConsecutiveDuplicates(String str) {
if (str == null || str.isEmpty()) {
return str;
}
StringBuilder result = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
if (i == 0) {                                                                                                
result.append(str.charAt(i));
}
else {
if (str.charAt(i) != str.charAt(i - 1)) {
result.append(str.charAt(i));
}
}
}
return result.toString();
}

public static void main(String args[]) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a string:");
String input = scanner.nextLine().toLowerCase();
String result = removeConsecutiveDuplicates(input);
System.out.println("Resulting string: " + result);
scanner.close();
}       
}
