import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {
    public static void main(String[] args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String CONN_STRING = "jdbc:mysql://localhost:3306/studentmca";
        String user = "root";
        String password = "";

        try(Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
        ){
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee location: ");
            String location = scanner.nextLine();
            System.out.print("Enter employee salary: ");
            int salary = scanner.nextInt();

            String query = "INSERT INTO employees (NAME, LOCATION, SALARY) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setInt(3, salary);

            preparedStatement.executeUpdate();

            System.out.println("Inserted employee record successfully...");

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
