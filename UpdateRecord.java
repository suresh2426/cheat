import java.sql.*;
import java.util.Scanner;

public class UpdateRecord {
    public static void main(String[] args){

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        }

        // Database connection details
        String CONN_STRING = "jdbc:mysql://localhost:3306/studentmca";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(CONN_STRING, user, password)) {
            // SQL query to update the employee record
            String query = "UPDATE employees SET NAME = ?, LOCATION = ?, SALARY = ? WHERE ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);

            // Get input from the user
            System.out.print("Enter the ID of the employee you want to update: ");
            int id = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the updated name of the employee: ");
            String name = scanner.nextLine();

            System.out.print("Enter the updated location of the employee: ");
            String location = scanner.nextLine();

            System.out.print("Enter the updated salary of the employee: ");
            int salary = scanner.nextInt();

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setInt(3, salary);
            preparedStatement.setInt(4, id);

            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();

            // Output the result
            if (rowsUpdated > 0) {
                System.out.println("Employee record updated successfully.");
            } else {
                System.out.println("No employee found with the given ID.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred.", e);
        }
    }
}
