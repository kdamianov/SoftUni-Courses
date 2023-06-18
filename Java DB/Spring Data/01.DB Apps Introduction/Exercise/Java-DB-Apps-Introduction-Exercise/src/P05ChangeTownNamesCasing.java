import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05ChangeTownNamesCasing {
    private static final String UPDATE_TOWNS_FROM_COUNTRY = "update towns set name = upper(name) where country = ?";
    private static final String SELECT_TOWNS_FROM_COUNTRY = "select name from towns where country = ?";

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String PRINT_TOWNS_FORMAT = "%d town names were affected.%n";
    private static final String NO_TOWNS_AFFECTED = "No town names were affected.";


    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country name: ");
        final String countryName = scanner.nextLine();

        PreparedStatement updateTownsStatement = sqlConnection.prepareStatement(UPDATE_TOWNS_FROM_COUNTRY);
        updateTownsStatement.setString(1, countryName);
        int updatedTownsCount = updateTownsStatement.executeUpdate();

        if (updatedTownsCount == 0) {
            System.out.println(NO_TOWNS_AFFECTED);
            return;
        }
        System.out.printf(PRINT_TOWNS_FORMAT, updatedTownsCount);

        PreparedStatement selectTownsStatement = sqlConnection.prepareStatement(SELECT_TOWNS_FROM_COUNTRY);
        selectTownsStatement.setString(1, countryName);
        ResultSet selectedTownsResult = selectTownsStatement.executeQuery();

        List<String> townsList = new ArrayList<>();

        while (selectedTownsResult.next()) {
            townsList.add(selectedTownsResult.getString(COLUMN_LABEL_NAME));
        }

        System.out.println(townsList);
        sqlConnection.close();
    }
}
