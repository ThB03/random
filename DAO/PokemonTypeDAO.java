package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypeDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public PokemonTypeDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find all Pokemon types by Pokemon ID from the database
    public List<String> findByPokemonId(long pokemonId) throws SQLException {
        List<String> pokemonTypes = new ArrayList<>();
        String sql = "SELECT * FROM pokemon_type WHERE pokemon_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, pokemonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pokemonTypes.add(extractPokemonType(resultSet));
                }
            }
        }
        return pokemonTypes;
    }

    // Helper method to extract PokemonType object from ResultSet
    private String extractPokemonType(ResultSet resultSet) throws SQLException {
        return resultSet.getString("type_id");
    }
}
