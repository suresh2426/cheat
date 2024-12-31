import java.sql.*;
import java.util.Scanner;

public class OracleDeleteRecord {
    public static void main(String[] args) {
        try {
            // Database connection details
            String serverName = "172.16.20.20";
            String portNumber = "1521";
            String sid = "orcl";

            String CONN_STRING = "jdbc:oracle:thin:@//" + serverName + ":" + portNumber + "/" + sid;
            String user = "C##mcaorc52"; // User credentials
            String password = "mcaorc52";

            // Establishing connection
            try (Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM emp WHERE eno = ?");
                 Scanner scanner = new Scanner(System.in)) {

                // Loop for repeated deletion
                while (true) {
                    System.out.print("Enter the employee number (ENO) you want to delete (or type 'exit' to quit): ");
                    
                    // Check for exit condition
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting program.");
                        break;
                    }

                    try {
                        int eno = Integer.parseInt(input); // Get employee number (ENO)

                        // Set parameter and execute deletion
                        preparedStatement.setInt(1, eno);
                        int rowsDeleted = preparedStatement.executeUpdate();

                        if (rowsDeleted > 0) {
                            System.out.println("Successfully deleted employee with ENO: " + eno);
                        } else {
                            System.out.println("No employee found with ENO: " + eno);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid employee number or type 'exit' to quit.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
