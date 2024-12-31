import java.util.Scanner;

public class NumberToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        String binaryString = Integer.toBinaryString(number);
        
        System.out.println("Binary format: " + binaryString);
        
        scanner.close();
    }
}
