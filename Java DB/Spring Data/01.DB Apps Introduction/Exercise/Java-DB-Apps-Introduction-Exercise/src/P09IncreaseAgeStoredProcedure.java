import java.sql.*;
import java.util.Scanner;

public class P09IncreaseAgeStoredProcedure {
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    private static final String CALL_PROCEDURE = "CALL usp_get_older(?)";
    private static final String SELECT_MINION_BY_ID = "SELECT name,age FROM minions WHERE id=?";
    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();
        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement = sqlConnection.prepareCall(CALL_PROCEDURE);
        callableStatement.setInt(1, minionId);
        callableStatement.executeUpdate();
        PreparedStatement statement = sqlConnection.prepareStatement(SELECT_MINION_BY_ID);
        statement.setInt(1, minionId);
        ResultSet updatedMinionInfo = statement.executeQuery();
        updatedMinionInfo.next();
        String minionName = updatedMinionInfo.getString(COLUMN_LABEL_NAME);
        int updatedMinionAge = updatedMinionInfo.getInt(COLUMN_LABEL_AGE);

        System.out.printf("%s %d", minionName, updatedMinionAge);
    }
}

//DELIMITER $$
//CREATE PROCEDURE usp_get_older(minion_id INT)
//BEGIN
//    UPDATE minions
//    SET age = age + 1
//    WHERE id = minion_id;
//END $$
//
//DELIMITER ;
