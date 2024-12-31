import java.sql.*;
import java.util.Scanner;

public class StoredProcedureInAndOut {  
    public static void main(String[] args) {
        String CONN_STRING = "jdbc:mysql://localhost:3306/studentmca";
        String user = "root";
        String password = "";

        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(CONN_STRING, user, password)) {

            // Query for the stored procedure
            String query = "{CALL getEmployeeName(?, ?)}";

            try (CallableStatement callableStatement = connection.prepareCall(query)) {
                // Input parameter
                System.out.print("Enter the employee ID to find the employee's name: ");
                int employeeId = scanner.nextInt();

                callableStatement.setInt(1, employeeId);

                // Output parameter
                callableStatement.registerOutParameter(2, Types.VARCHAR);

                // Execute the procedure
                callableStatement.execute();

                // Retrieve the output parameter
                String result = callableStatement.getString(2);

                if (result != null) {
                    System.out.println("The employee's name is: " + result);
                } else {
                    System.out.println("No employee found with the given ID.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
