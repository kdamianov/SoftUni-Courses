import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P07PrintAllMinionNames {
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String GET_ALL_MINIONS_BY_NAME = "select name from minions";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        PreparedStatement getMinionsByNameStmt = sqlConnection.prepareStatement(GET_ALL_MINIONS_BY_NAME);
        ResultSet minionNamesResult = getMinionsByNameStmt.executeQuery();
        List<String> minions = new ArrayList<>();

        while (minionNamesResult.next()) {
            String minionName = minionNamesResult.getString(COLUMN_LABEL_NAME);
            minions.add(minionName);
        }

        int startInd = 0;
        int endInd = minions.size() - 1;

        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minions.get(startInd++)
                    : minions.get(endInd--));
        }

        sqlConnection.close();
    }
}
