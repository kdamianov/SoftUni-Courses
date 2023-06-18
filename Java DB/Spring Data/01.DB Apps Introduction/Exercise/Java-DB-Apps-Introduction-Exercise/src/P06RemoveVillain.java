import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06RemoveVillain {
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String FIND_VILLAIN_NAME_BY_ID = "select name from villains where id = ?";
    private static final String DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID =
            "delete from minions_villains where villain_id = ?";
    private static final String GET_COUNT_OF_MINIONS_BY_VILLAIN_ID =
            "select count(*) as minions_count from minions_villains where villain_id = ?";
    private static final String DELETE_VILLAIN_BY_ID = "delete from villains where id = ?";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();
        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement findVillainNameStmt = sqlConnection.prepareStatement(FIND_VILLAIN_NAME_BY_ID);
        findVillainNameStmt.setInt(1, villainId);

        ResultSet villainResultSet = findVillainNameStmt.executeQuery();

        if (!villainResultSet.next()) {
            System.out.println("No such villain was found");
            return;
        }
        String villainName = villainResultSet.getString(COLUMN_LABEL_NAME);

        sqlConnection.setAutoCommit(false);

        try {
            PreparedStatement deleteMinionsVillainsStmt = sqlConnection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID);
            deleteMinionsVillainsStmt.setInt(1, villainId);
            int minionsCount = deleteMinionsVillainsStmt.executeUpdate();

            PreparedStatement deleteVillainStmt = sqlConnection.prepareStatement(DELETE_VILLAIN_BY_ID);
            deleteVillainStmt.setInt(1, villainId);
            deleteVillainStmt.executeUpdate();

            sqlConnection.commit();
            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", minionsCount);

        } catch (SQLException e) {
            sqlConnection.rollback();
        }
        sqlConnection.close();
    }
}
