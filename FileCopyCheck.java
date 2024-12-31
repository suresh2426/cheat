// Write a java program to check whether the file given exists. If exists copy it to the another file.

import java.io.*;

public class FileCopyCheck {
    public static void main(String[] args) {
        try {
            // Create a BufferedReader to accept input from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Prompt the user for the source file
            System.out.print("Enter the source file path: ");
            String sourceFilePath = reader.readLine();

            // Create a File object for the source file
            File sourceFile = new File(sourceFilePath);

            // Check if the source file exists
            if (!sourceFile.exists() || !sourceFile.isFile()) {
                System.out.println("Error: The source file does not exist or is not a valid file.");
                return;
            }

            // Prompt the user for the destination file
            System.out.print("Enter the destination file path: ");
            String destFilePath = reader.readLine();

            // Create a File object for the destination file
            File destFile = new File(destFilePath);

            // Call the method to copy the file
            copyFile(sourceFile, destFile);

            System.out.println("File copied successfully from " + sourceFilePath + " to " + destFilePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to copy a file
    private static void copyFile(File sourceFile, File destFile) throws IOException {
        // Create input and output streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            // Buffer for data transfer
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from source and write to destination
            while ((bytesRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
