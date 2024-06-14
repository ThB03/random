package DAO;

import Model.Team;
import requests.TeamRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to find all teams by username from the database
    public List<Team> findAllByUsername(String username) throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM teams WHERE user = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    teams.add(extractTeam(resultSet));
                }
            }
        }
        return teams;
    }

    // Method to find a team by ID from the database
    public Team findById(long teamId) throws SQLException {
        String sql = "SELECT * FROM teams WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractTeam(resultSet);
                }
            }
        }
        return null;
    }

    // Method to delete a team by ID from the database
    public void deleteById(long teamId) throws SQLException {
        String sql = "DELETE FROM teams WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, teamId);
            statement.executeUpdate();
        }
    }

    // Helper method to extract Team object from ResultSet
    private Team extractTeam(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String username = resultSet.getString("user");
        String teamName = resultSet.getString("team_name");
        long poke1 = resultSet.getLong("poke1");
        long move11 = resultSet.getLong("move11");
        long move12 = resultSet.getLong("move12");
        long move13 = resultSet.getLong("move13");
        long move14 = resultSet.getLong("move14");
        long poke2 = resultSet.getLong("poke2");
        long move21 = resultSet.getLong("move21");
        long move22 = resultSet.getLong("move22");
        long move23 = resultSet.getLong("move23");
        long move24 = resultSet.getLong("move24");
        long poke3 = resultSet.getLong("poke3");
        long move31 = resultSet.getLong("move31");
        long move32 = resultSet.getLong("move32");
        long move33 = resultSet.getLong("move33");
        long move34 = resultSet.getLong("move34");
        long poke4 = resultSet.getLong("poke4");
        long move41 = resultSet.getLong("move41");
        long move42 = resultSet.getLong("move42");
        long move43 = resultSet.getLong("move43");
        long move44 = resultSet.getLong("move44");
        long poke5 = resultSet.getLong("poke5");
        long move51 = resultSet.getLong("move51");
        long move52 = resultSet.getLong("move52");
        long move53 = resultSet.getLong("move53");
        long move54 = resultSet.getLong("move54");
        long poke6 = resultSet.getLong("poke6");
        long move61 = resultSet.getLong("move61");
        long move62 = resultSet.getLong("move62");
        long move63 = resultSet.getLong("move63");
        long move64 = resultSet.getLong("move64");

        return new Team(id, username, teamName, poke1, move11, move12, move13, move14,
                poke2, move21, move22, move23, move24, poke3, move31, move32, move33, move34,
                poke4, move41, move42, move43, move44, poke5, move51, move52, move53, move54,
                poke6, move61, move62, move63, move64);
    }

    // Method to insert a new Team using TeamRequest (assuming TeamRequest matches Team fields)
    public void insertFromTeamRequest(TeamRequest teamRequest) throws SQLException {
        String sql = "INSERT INTO teams (user, team_name, poke1, move11, move12, move13, move14, " +
                "poke2, move21, move22, move23, move24, poke3, move31, move32, move33, move34, " +
                "poke4, move41, move42, move43, move44, poke5, move51, move52, move53, move54, " +
                "poke6, move61, move62, move63, move64) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, teamRequest.getUsername());
            statement.setString(2, teamRequest.getTeamName());
            statement.setLong(3, teamRequest.getPoke1());
            statement.setLong(4, teamRequest.getMove11());
            statement.setLong(5, teamRequest.getMove12());
            statement.setLong(6, teamRequest.getMove13());
            statement.setLong(7, teamRequest.getMove14());
            statement.setLong(8, teamRequest.getPoke2());
            statement.setLong(9, teamRequest.getMove21());
            statement.setLong(10, teamRequest.getMove22());
            statement.setLong(11, teamRequest.getMove23());
            statement.setLong(12, teamRequest.getMove24());
            statement.setLong(13, teamRequest.getPoke3());
            statement.setLong(14, teamRequest.getMove31());
            statement.setLong(15, teamRequest.getMove32());
            statement.setLong(16, teamRequest.getMove33());
            statement.setLong(17, teamRequest.getMove34());
            statement.setLong(18, teamRequest.getPoke4());
            statement.setLong(19, teamRequest.getMove41());
            statement.setLong(20, teamRequest.getMove42());
            statement.setLong(21, teamRequest.getMove43());
            statement.setLong(22, teamRequest.getMove44());
            statement.setLong(23, teamRequest.getPoke5());
            statement.setLong(24, teamRequest.getMove51());
            statement.setLong(25, teamRequest.getMove52());
            statement.setLong(26, teamRequest.getMove53());
            statement.setLong(27, teamRequest.getMove54());
            statement.setLong(28, teamRequest.getPoke6());
            statement.setLong(29, teamRequest.getMove61());
            statement.setLong(30, teamRequest.getMove62());
            statement.setLong(31, teamRequest.getMove63());
            statement.setLong(32, teamRequest.getMove64());

            statement.executeUpdate();
        }
    }
}
