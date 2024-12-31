import java.util.*;

public class StackQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack Implementation
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack Operations:");
        System.out.println("1. Push to Stack");
        System.out.println("2. Pop from Stack");
        System.out.println("3. Display Stack");
        System.out.println("4. Exit Stack Operations");
        int choice;
        do {
            System.out.print("\nEnter your choice for Stack: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int num = scanner.nextInt();
                    stack.push(num);
                    System.out.println("Pushed " + num + " to stack.");
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        int popped = stack.pop();
                        System.out.println("Popped: " + popped);
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;

                case 3:
                    System.out.println("Stack contents: " + stack);
                    break;

                case 4:
                    System.out.println("Exiting Stack Operations.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        // Queue Implementation
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("\nQueue Operations:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display Queue");
        System.out.println("4. Exit Queue Operations");
        do {
            System.out.print("\nEnter your choice for Queue: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    int num = scanner.nextInt();
                    queue.add(num);
                    System.out.println("Enqueued " + num + " to queue.");
                    break;

                case 2:
                    if (!queue.isEmpty()) {
                        int dequeued = queue.poll();
                        System.out.println("Dequeued: " + dequeued);
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;

                case 3:
                    System.out.println("Queue contents: " + queue);
                    break;

                case 4:
                    System.out.println("Exiting Queue Operations.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
