package responses;

public class UserResponse {
    private int status;
    private String message;
    private String username;
    private String session;

    // Default constructor
    public UserResponse() {
    }

    // All-args constructor
    public UserResponse(int status, String message, String username, String session) {
        this.status = status;
        this.message = message;
        this.username = username;
        this.session = session;
    }

    // Getter for status
    public int getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(int status) {
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
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
}
