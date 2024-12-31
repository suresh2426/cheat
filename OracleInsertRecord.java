import java.sql.*;
import java.util.Scanner;

public class OracleInsertRecord {
    public static void main(String[] args) {
        String serverName = "172.16.20.20";
        String portNumber = "1521";
        String sid = "orcl";

        String CONN_STRING = "jdbc:oracle:thin:@//" + serverName + ":" + portNumber + "/" + sid;
        String user = "C##mcaorc52";
        String password = "mcaorc52";

        try (Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
             Scanner scanner = new Scanner(System.in)) {

            String query = "INSERT INTO emp (ENO, ENAME, DESIGN) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            while (true) {
                // User input
                System.out.print("Enter Employee Number (ENO): ");
                int eno = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                System.out.print("Enter Employee Name (ENAME): ");
                String ename = scanner.nextLine();

                System.out.print("Enter Designation (DESIGN): ");
                String design = scanner.nextLine();

                // Setting values in PreparedStatement
                preparedStatement.setInt(1, eno);
                preparedStatement.setString(2, ename);
                preparedStatement.setString(3, design);

                // Execute the update
                try {
                    int rowsInserted = preparedStatement.executeUpdate();
                    System.out.println(rowsInserted + " record(s) inserted successfully.");
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.err.println("Error: Duplicate entry or constraint violation.");
                }

                // Ask user if they want to insert another record
                System.out.print("Do you want to insert another record? (yes to continue, exit to quit): ");
                String choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("exit")) {
                    System.out.println("Exiting the program.");
                    break;
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
