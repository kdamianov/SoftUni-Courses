import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDemo {
    private static final String SELECT_USER_GAMES_COUNT_BY_USERNAME =
            "SELECT first_name, last_name, COUNT(ug.game_id) FROM users as u " +
            "JOIN users_games AS ug ON ug.user_id = u.id " +
            "WHERE user_name = ? " +
            "GROUP BY u.id";
    public static void main(String[] args) throws SQLException {
//----1. Establish a connection to the database----

        Connection connection = getMySQLConnection();

//----2. Username and statement----

        String username = readUsername();

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAMES_COUNT_BY_USERNAME);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        boolean hasRow = result.next();

//----3. Output----

        if (hasRow) {
            System.out.printf("User: %s%n", username);
            System.out.printf("%s %s has played %d games",
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getInt(3)); // ИНдексът на колоната, която е върната, за да не пишем "COUNT(ug.game_id)"
        } else {
            System.out.println("No such user exists");
        }
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine(); //дефинираме username

        return username;
    }

    private static Connection getMySQLConnection() throws SQLException {
//        Properties userPass = new Properties();
//        userPass.setProperty("user", "root");
//        userPass.setProperty("password", "****");

//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/diablo", userPass);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diablo", "root", "****");
        return connection;
    }
}
