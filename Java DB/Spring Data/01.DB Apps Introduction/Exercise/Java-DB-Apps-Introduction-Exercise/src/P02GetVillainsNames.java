import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class P02GetVillainsNames {
    private static final String GET_VILLAINS_BY_NAME = "select v.name, count(distinct mv.minion_id) as 'count_of_minions' " +
            "from villains as v " +
            "         join minions_villains mv on v.id = mv.villain_id " +
            "group by v.id " +
            "having count_of_minions > ? " +
            "order by count_of_minions desc;";
    private static final String PRINT_FORMAT = "%s %d";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_COUNT_OF_MINIONS = "count_of_minions";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        final PreparedStatement statement = sqlConnection.prepareStatement(GET_VILLAINS_BY_NAME);
        statement.setInt(1, 15);

        final ResultSet result = statement.executeQuery();

        while (result.next()){
            print(result);
        }

        sqlConnection.close();
    }

    private static void print(ResultSet resultSet) throws SQLException {
        final String name = resultSet.getString(COLUMN_LABEL_NAME);
        final int countOfMinions = resultSet.getInt(COLUMN_LABEL_COUNT_OF_MINIONS);

        System.out.printf(PRINT_FORMAT, name, countOfMinions);
    }
}