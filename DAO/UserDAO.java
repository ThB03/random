package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    // Constructor to initialize connection (replace with your actual database connection logic)
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to insert a new User into the database
    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO users (email, password, username) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.executeUpdate();
        }
    }

    // Method to find a User by email from the database
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUser(resultSet);
                }
            }
        }
        return null;
    }

    // Helper method to extract User object from ResultSet
    private User extractUser(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String username = resultSet.getString("username");
        return new User(id, email, password, username);
    }
}