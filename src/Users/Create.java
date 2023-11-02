package Users;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create {
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final String company;
    private final String notes;

    public Create(String name, String phoneNumber, String email, String company, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.company = company;
        this.notes = notes;
    }

    public void createUser() {
        Connection connection = null;
        PreparedStatement myStatement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String query = "INSERT INTO users (name, phone_number, email, company, notes) VALUES (?, ?, ?, ?, ?)";
            myStatement = connection.prepareStatement(query);

            myStatement.setString(1, name);
            myStatement.setString(2, phoneNumber);
            myStatement.setString(3, email);
            myStatement.setString(4, company);
            myStatement.setString(5, notes);

            int rowsAffected = myStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New user has been created successfully");
            }

            DatabaseConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
