import java.util.Scanner;
import java.math.BigInteger;

class FibonacciRunnable implements Runnable {
    private int n;

    public FibonacciRunnable(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Fibonacci Series (User-defined times)");
        for (int j = 1; j <= 5; j++) {
            int a = 0, b = 1;
            System.out.print("Fibonacci Series " + j + ": ");
            for (int i = 0; i < n; i++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
            }
            System.out.println();
        }
    }
}

class FactorialRunnable implements Runnable {
    private int maxFactorial;

    public FactorialRunnable(int maxFactorial) {
        this.maxFactorial = maxFactorial;
    }

    public void run() {
        System.out.println("Factorial Calculation (User-defined range)");
        for (int j = 1; j <= maxFactorial; j++) {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= j; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println("Factorial of " + j + " is " + factorial);
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        int fibonacciCount = scanner.nextInt();

        // Get input for factorial range
        System.out.print("Enter the maximum number for factorial calculation: ");
        int factorialMax = scanner.nextInt();

        // Validate inputs
        if (fibonacciCount <= 0) {
            System.out.println("Error: The number of Fibonacci numbers must be greater than 0.");
            scanner.close();
            return;
        }

        if (factorialMax <= 0) {
            System.out.println("Error: The maximum number for factorial calculation must be greater than 0.");
            scanner.close();
            return;
        }

        
        Runnable fibonacciTask = new FibonacciRunnable(fibonacciCount);
        Runnable factorialTask = new FactorialRunnable(factorialMax);

        // Create threads
        Thread fibonacciThread = new Thread(fibonacciTask);
        Thread factorialThread = new Thread(factorialTask);

        // Start threads
        fibonacciThread.start();
        factorialThread.start();

        scanner.close();
    }
}
