package DAO;

import Model.Pokemon;
import Model.SimplePokedexEntryClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public PokemonDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find a Pokemon by ID from the database
    public Pokemon findById(long id) throws SQLException {
        String sql = "SELECT * FROM pokemon WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractPokemon(resultSet);
                }
            }
        }
        return null;
    }

    // Method to fetch all Pokemon from the database
    public List<Pokemon> findAll() throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();
        String sql = "SELECT * FROM pokemon";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pokemon pokemon = extractPokemon(resultSet);
                pokemonList.add(pokemon);
            }
        }
        return pokemonList;
    }

    // Method to retrieve simplified Pokédex entries (SimplePokedexEntryClass)
    public List<SimplePokedexEntryClass> findSimpleAll() throws SQLException {
        List<SimplePokedexEntryClass> simplePokedex = new ArrayList<>();
        String sql = "SELECT id, name, image FROM pokemon";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                SimplePokedexEntryClass simpleEntry = new SimplePokedexEntryClass(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image")
                );
                simplePokedex.add(simpleEntry);
            }
        }
        return simplePokedex;
    }

    // Helper method to extract Pokemon object from ResultSet
    private Pokemon extractPokemon(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String image = resultSet.getString("image");
        long total = resultSet.getLong("total");
        long hp = resultSet.getLong("hp");
        long attack = resultSet.getLong("attack");
        long defense = resultSet.getLong("defense");
        long spAtt = resultSet.getLong("sp_att");
        long spDef = resultSet.getLong("sp_def");
        long speed = resultSet.getLong("speed");
        String flavor = resultSet.getString("flavor");

        return new Pokemon(id, name, image, total, hp, attack, defense, spAtt, spDef, speed, flavor);
    }

}
