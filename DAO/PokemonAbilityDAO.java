package DAO;

import Model.PokemonAbility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonAbilityDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public PokemonAbilityDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find Pokemon abilities by Pokemon ID from the database
    public List<PokemonAbility> findByPokemonId(long pokemonId) throws SQLException {
        List<PokemonAbility> pokemonAbilities = new ArrayList<>();
        String sql = "SELECT * FROM pokemon_ability WHERE pokemon_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, pokemonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pokemonAbilities.add(extractPokemonAbility(resultSet));
                }
            }
        }
        return pokemonAbilities;
    }

    // Helper method to extract PokemonAbility object from ResultSet
    private PokemonAbility extractPokemonAbility(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long pokemonId = resultSet.getLong("pokemon_id");
        long abilityId = resultSet.getLong("ability_id");
        return new PokemonAbility(id, pokemonId, abilityId);
    }
}
