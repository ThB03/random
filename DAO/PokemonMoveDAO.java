package DAO;

import Model.PokemonMove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonMoveDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public PokemonMoveDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find Pokemon moves by Pokemon ID from the database
    public List<PokemonMove> findByPokemonId(long pokemonId) throws SQLException {
        List<PokemonMove> pokemonMoves = new ArrayList<>();
        String sql = "SELECT * FROM pokemon_move WHERE pokemon_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, pokemonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pokemonMoves.add(extractPokemonMove(resultSet));
                }
            }
        }
        return pokemonMoves;
    }

    // Helper method to extract PokemonMove object from ResultSet
    private PokemonMove extractPokemonMove(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long pokemonId = resultSet.getLong("pokemon_id");
        long moveId = resultSet.getLong("move_id");
        return new PokemonMove(id, pokemonId, moveId);
    }
}
