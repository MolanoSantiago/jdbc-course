import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm-react", "root", "");
            System.out.println("We are connected successfully");

            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery("SELECT * FROM users");

            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Something bad has happened");
            throw new RuntimeException(e);
        }
    }
}