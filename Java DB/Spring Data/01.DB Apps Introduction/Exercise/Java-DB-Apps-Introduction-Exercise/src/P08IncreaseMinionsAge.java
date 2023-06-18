import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class P08IncreaseMinionsAge {
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";

    private static final String UPDATE_MINIONS_BY_ID =
            "update minions set age = age +1, name = lower(name) where id = ?";
    private static final String SELECT_ALL_MINIONS = "select name, age from minions";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();
        Scanner scanner = new Scanner(System.in);

        final int[] minionIDs = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int minionID : minionIDs) {
            PreparedStatement statement = sqlConnection.prepareStatement(UPDATE_MINIONS_BY_ID);
            statement.setInt(1, minionID);
            statement.executeUpdate();
        }
        PreparedStatement getUpdatedMinions = sqlConnection.prepareStatement(SELECT_ALL_MINIONS);
        ResultSet updatedMinions = getUpdatedMinions.executeQuery();

        while (updatedMinions.next()) {
            String minionName = updatedMinions.getString(COLUMN_LABEL_NAME);
            int minionAge = updatedMinions.getInt(COLUMN_LABEL_AGE);
            System.out.printf("%s %d%n", minionName, minionAge);
        }

    }
}
