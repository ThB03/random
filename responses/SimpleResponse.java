package responses;

public class SimpleResponse {
    private int status;
    private String message;

    // Default constructor
    public SimpleResponse() {
    }

    // All-args constructor
    public SimpleResponse(int status, String message) {
        this.status = status;
        this.message = message;
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
}
