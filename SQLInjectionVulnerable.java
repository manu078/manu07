import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionVulnerable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Vulnerable SQL query construction
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        try {
            Connection connection = getConnection(); // Assume this method establishes a database connection
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the retrieved data
                System.out.println("User: " + resultSet.getString("username"));
                // Other user details...
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    // Placeholder for getConnection method
    private static Connection getConnection() throws SQLException {
        // Implementation to establish a database connection
        return null;
    }
}
