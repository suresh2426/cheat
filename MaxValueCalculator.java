// Write a class with a static method that returns the maximum value of three given integers. Write another class with main method and call the static method to print the maximum values for two sets of integer values(for eg. {10,15,100}, {75,89,200}).


import java.util.*;

class MaxFinder {
    public static int findMax(int a, int b, int c) {
        int max = a; 
        if (b > max) {
            max = b; 
        }
        if (c > max) {
            max = c; 
        }
        return max; 
    }
}

public class MaxValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	int num1, num2, num3, max;

        System.out.println("Enter three integers for the first set:");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        max = MaxFinder.findMax(num1, num2, num3);
        System.out.println("The maximum value of the first set is: " + max);

        System.out.println("Enter three integers for the second set:");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        max = MaxFinder.findMax(num1, num2, num3);
        System.out.println("The maximum value of the second set is: " + max);


        scanner.close();
    }
}
