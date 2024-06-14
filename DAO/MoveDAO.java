package DAO;

import Model.Move;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoveDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public MoveDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find a Move by ID from the database
    public Move findById(long id) throws SQLException {
        String sql = "SELECT * FROM move WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractMove(resultSet);
                }
            }
        }
        return null;
    }

    // Helper method to extract Move object from ResultSet
    private Move extractMove(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String effect = resultSet.getString("effect");
        return new Move(id, name, effect);
    }
}
