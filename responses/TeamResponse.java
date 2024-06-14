package responses;

import Model.Team;
import java.util.List;

public class TeamResponse {
    private int status;
    private String message;
    private List<Team> teams;

    // Default constructor
    public TeamResponse() {
    }

    // All-args constructor
    public TeamResponse(int status, String message, List<Team> teams) {
        this.status = status;
        this.message = message;
        this.teams = teams;
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

    // Getter for teams
    public List<Team> getTeams() {
        return teams;
    }

    // Setter for teams
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
