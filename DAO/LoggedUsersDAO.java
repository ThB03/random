package DAO;

import Model.LoggedUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoggedUsersDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public LoggedUsersDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to insert a new logged user into the database
    public void insert(LoggedUsers loggedUsers) throws SQLException {
        String sql = "INSERT INTO logged_users (session, username) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, loggedUsers.getSession());
            statement.setString(2, loggedUsers.getUsername());
            statement.executeUpdate();
        }
    }

    // Method to find a logged user by session from the database
    public LoggedUsers findBySession(String session) throws SQLException {
        String sql = "SELECT * FROM logged_users WHERE session = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, session);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractLoggedUser(resultSet);
                }
            }
        }
        return null;
    }

    // Helper method to extract LoggedUsers object from ResultSet
    private LoggedUsers extractLoggedUser(ResultSet resultSet) throws SQLException {
        String session = resultSet.getString("session");
        String username = resultSet.getString("username");
        return new LoggedUsers(session, username);
    }
}

