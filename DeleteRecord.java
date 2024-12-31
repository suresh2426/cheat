import java.sql.*;
import java.util.Scanner;

public class DeleteRecord {
  public static void main(String[] args) {

    try {
      // Load MySQL JDBC Driver
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("MySQL JDBC Driver not found.", e);
    }

    // Database connection details
    String CONN_STRING = "jdbc:mysql://localhost:3306/studentmca";
    String user = "root";
    String password = "";

    try (
        Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE ID = ?");
        Scanner scanner = new Scanner(System.in)
    ) {
      // Get the ID of the employee to delete
      System.out.print("Enter the ID of the employee you want to delete: ");
      int employeeId = scanner.nextInt();

      // Set the ID parameter in the SQL query
      preparedStatement.setInt(1, employeeId);

      // Execute the delete query and show feedback
      int rowsDeleted = preparedStatement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Employee record deleted successfully.");
      } else {
        System.out.println("No employee found with the given ID.");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
