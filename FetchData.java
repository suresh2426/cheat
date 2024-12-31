import java.sql.*;

public class FetchData {
    public static void main(String[] args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String CONN_STRING = "jdbc:mysql://localhost:3306/learning";
        String user = "root";
        String password = "";

        try(Connection connection = DriverManager.getConnection(CONN_STRING, user, password);
            Statement statement = connection.createStatement()
        ){
            String query = "SELECT * FROM users";
            ResultSet rs = statement.executeQuery(query);

            var meta = rs.getMetaData();

            for(int i = 1; i <= meta.getColumnCount(); i++){
                System.out.printf("%-15s", meta.getColumnName(i));
            }
            System.out.println();

            while(rs.next()){
                for(int i = 1; i <= meta.getColumnCount(); i++){
                    System.out.printf("%-15s", rs.getString(i));
                }
                System.out.println();
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
