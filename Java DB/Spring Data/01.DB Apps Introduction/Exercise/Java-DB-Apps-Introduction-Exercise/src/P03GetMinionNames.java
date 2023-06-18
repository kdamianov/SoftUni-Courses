import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03GetMinionNames {
    private static final String GET_MINIONS_AGE_BY_VILLAIN_ID = "select m.name, m.age from minions as m " +
            "    join minions_villains mv on m.id = mv.minion_id " +
            "where mv.villain_id = ?;";

    private static final String GET_VILLAIN_NAME_BY_ID = "select name " +
            "from villains " +
            "where id = ?;";
    private static final String PRINT_VILLAIN_FORMAT = "Villain: %s%n";
    private static final String PRINT_MINION_FORMAT = "%d. %s %d%n";
    private static final String PRINT_NO_VILLAIN_FOUND = "No villain with ID %d exists in the database.";

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();
        final int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement villainsStatement = sqlConnection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        villainsStatement.setInt(1, villainId);

        final ResultSet villainResultSet = villainsStatement.executeQuery();
        if (!villainResultSet.next()) {
            System.out.printf(PRINT_NO_VILLAIN_FOUND, villainId);

            sqlConnection.close();
            return;
        }

        final PreparedStatement minionsStatement = sqlConnection.prepareStatement(GET_MINIONS_AGE_BY_VILLAIN_ID);
        minionsStatement.setInt(1, villainId);

        final ResultSet minionResultSet = minionsStatement.executeQuery();

        print(villainResultSet, minionResultSet);
        sqlConnection.close();
    }

    private static void print(ResultSet villains, ResultSet minions) throws SQLException {
        final String villainName = villains.getString(COLUMN_LABEL_NAME);
        System.out.printf(PRINT_VILLAIN_FORMAT, villainName);

        for (int index = 1; minions.next(); index++) {
            final String minionName = minions.getString(COLUMN_LABEL_NAME);
            final int minionAge = minions.getInt(COLUMN_LABEL_AGE);

            System.out.printf(PRINT_MINION_FORMAT, index, minionName, minionAge);
        }
    }
}
