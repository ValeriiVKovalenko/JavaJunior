package javarush.shop.dao.product_description_dao;

import javarush.shop.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLLiteProductDescriptionDAO implements ProductDescriptionDAO {
    DatabaseManager databaseManager;

    public SQLLiteProductDescriptionDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public List<String> getProductTypes() {
       List<String> productTypes = new ArrayList<>();
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT type FROM Descriptions")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                productTypes.add(type);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productTypes;
    }
}
