package Model;

public class LoggedUsers {
    private String session;
    private String username;

    // No-argument constructor
    public LoggedUsers() {
    }

    // All-argument constructor
    public LoggedUsers(String session, String username) {
        this.session = session;
        this.username = username;
    }

    // Getter for session
    public String getSession() {
        return session;
    }

    // Setter for session
    public void setSession(String session) {
        this.session = session;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }
}
