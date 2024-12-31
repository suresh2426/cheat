import java.sql.*;

public class OracleFetchData {
    public static void main(String[] args) {
        String serverName = "172.16.20.20";
        String portNumber = "1521";
        String sid = "orcl";

        // Updated credentials
        String CONN_STRING = "jdbc:oracle:thin:@//" + serverName + ":" + portNumber + "/" + sid;
        String user = "C##mcaorc52";
        String password = "mcaorc52";

        // Try-with-resources for automatic resource management
        try (Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM emp")) { // Query updated for the 'emp' table

            // Get ResultSet metadata
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", meta.getColumnName(i));
            }
            System.out.println();
            System.out.println("=".repeat(columnCount * 20)); // Separator line for clarity

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
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
