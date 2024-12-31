// Write a Java program using arrays to solve the problem. The problem is to read n numbers, get the average of these numbers, and find the number of the items greater than the average.

import java.util.*;

public class AverageGreaterThan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        double[] numbers = new double[n];
        
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }
        double average = sum / n;
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > average) {
                count++;
            }
        }
        
        System.out.println("Average: " + average);
        System.out.println("Number of items greater than the average: " + count);
        
        scanner.close();
    }
}
