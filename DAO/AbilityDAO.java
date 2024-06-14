package DAO;

import Model.Ability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbilityDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public AbilityDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find an Ability by ID from the database
    public Ability findById(long id) throws SQLException {
        String sql = "SELECT * FROM ability WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractAbility(resultSet);
                }
            }
        }
        return null;
    }

    // Helper method to extract Ability object from ResultSet
    private Ability extractAbility(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String effect = resultSet.getString("effect");
        return new Ability(id, name, effect);
    }
}
