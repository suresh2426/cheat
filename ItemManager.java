// Write a java program to read item information (id, name, quantity, price). In a item.dat file.
// Write a menu drive program to perform the following application using random access file
// a. search for a specific item by name.
// b. Display all item and total costs
// c. Find the costliest item.

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ItemManager {
    private static final String FILE_NAME = "item.dat";

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw");
             Scanner scanner = new Scanner(System.in)) {

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add item");
                System.out.println("2. Search for an item by name");
                System.out.println("3. Display all items and total cost");
                System.out.println("4. Find the costliest item");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addItem(file, scanner);
                        break;
                    case 2:
                        searchItemByName(file, scanner);
                        break;
                    case 3:
                        displayItemsAndTotalCost(file);
                        break;
                    case 4:
                        findCostliestItem(file);
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 5);

        } catch (IOException e) {
            System.out.println("Error handling the file: " + e.getMessage());
        }
    }

    // Method to add an item to the file
    private static void addItem(RandomAccessFile file, Scanner scanner) throws IOException {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        // Move to the end of the file
        file.seek(file.length());

        // Write item details
        file.writeInt(id);
        file.writeUTF(name);
        file.writeInt(quantity);
        file.writeDouble(price);

        System.out.println("Item added successfully!");
    }

    // Method to search for an item by name
    private static void searchItemByName(RandomAccessFile file, Scanner scanner) throws IOException {
        System.out.print("Enter the item name to search: ");
        String searchName = scanner.nextLine();

        file.seek(0);
        boolean found = false;

        while (file.getFilePointer() < file.length()) {
            int id = file.readInt();
            String name = file.readUTF();
            int quantity = file.readInt();
            double price = file.readDouble();

            if (name.equalsIgnoreCase(searchName)) {
                System.out.println("Item Found:");
                System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Method to display all items and calculate total cost
    private static void displayItemsAndTotalCost(RandomAccessFile file) throws IOException {
        file.seek(0);
        double totalCost = 0;

        System.out.println("\nItems:");
        System.out.println("ID\tName\t\tQuantity\tPrice");

        while (file.getFilePointer() < file.length()) {
            int id = file.readInt();
            String name = file.readUTF();
            int quantity = file.readInt();
            double price = file.readDouble();

            totalCost += quantity * price;
            System.out.println(id + "\t" + name + "\t\t" + quantity + "\t\t" + price);
        }

        System.out.println("\nTotal Cost: " + totalCost);
    }

    // Method to find the costliest item
    private static void findCostliestItem(RandomAccessFile file) throws IOException {
        file.seek(0);
        String costliestItem = null;
        double highestPrice = 0;

        while (file.getFilePointer() < file.length()) {
            int id = file.readInt();
            String name = file.readUTF();
            int quantity = file.readInt();
            double price = file.readDouble();

            if (price > highestPrice) {
                highestPrice = price;
                costliestItem = name;
            }
        }

        if (costliestItem != null) {
            System.out.println("Costliest Item: " + costliestItem + " with price " + highestPrice);
        } else {
            System.out.println("No items found.");
        }
    }
}
