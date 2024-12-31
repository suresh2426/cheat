import java.sql.*;
import java.util.Scanner;

public class OracleUpdateRecord {
    public static void main(String[] args) {
        try {
            // Database connection details
            String serverName = "172.16.20.20";
            String portNumber = "1521";
            String sid = "orcl";

            String CONN_STRING = "jdbc:oracle:thin:@//" + serverName + ":" + portNumber + "/" + sid;
            String user = "C##mcaorc52"; // User credentials (updated to your user)
            String password = "mcaorc52";

            // Establishing connection
            try (Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE emp SET ename = ?, design = ? WHERE eno = ?");
                 Scanner scanner = new Scanner(System.in)) {

                // Loop for repeated update
                while (true) {
                    System.out.print("Enter the employee number (ENO) you want to update (or type 'exit' to quit): ");
                    
                    // Check for exit condition
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting program.");
                        break;
                    }

                    try {
                        int eno = Integer.parseInt(input); // Get employee number (ENO)

                        System.out.print("Enter the updated name of the employee: ");
                        String ename = scanner.nextLine();

                        System.out.print("Enter the updated designation of the employee: ");
                        String design = scanner.nextLine();

                        // Set parameters and execute update
                        preparedStatement.setString(1, ename);
                        preparedStatement.setString(2, design);
                        preparedStatement.setInt(3, eno);

                        int rowsUpdated = preparedStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Successfully updated employee with ENO: " + eno);
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
