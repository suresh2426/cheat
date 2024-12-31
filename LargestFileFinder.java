// Write a java program that finds the largest file in the given directory.

import java.io.File;
import java.util.Scanner;

public class LargestFileFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask the user for the directory path
            System.out.print("Enter the directory path: ");
            String path = scanner.nextLine().trim();

            // Create a File object for the given directory
            File directory = new File(path);

            // Check if the given path is a valid directory
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Error: The provided path is not a valid directory.");
                return;
            }

            // Find the largest file
            File largestFile = findLargestFile(directory);

            // Display the result
            if (largestFile != null) {
                System.out.println("Largest file: " + largestFile.getName());
                System.out.println("Size: " + largestFile.length() + " bytes");
            } else {
                System.out.println("No files found in the directory.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to find the largest file in a directory
    private static File findLargestFile(File directory) {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File largestFile = null;

        for (File file : files) {
            if (file.isFile()) {
                // Compare file sizes
                if (largestFile == null || file.length() > largestFile.length()) {
                    largestFile = file;
                }
            } else if (file.isDirectory()) {
                // Recursively search in subdirectories
                File largestInSubdir = findLargestFile(file);
                if (largestFile == null || (largestInSubdir != null && largestInSubdir.length() > largestFile.length())) {
                    largestFile = largestInSubdir;
                }
            }
        }

        return largestFile;
    }
}
