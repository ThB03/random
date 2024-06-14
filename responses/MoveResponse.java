package responses;

import Model.Move;
import java.util.List;

public class MoveResponse {
    private int status;
    private String message;
    private List<Move> moves;

    // Default constructor
    public MoveResponse() {
    }

    // All-args constructor
    public MoveResponse(int status, String message, List<Move> moves) {
        this.status = status;
        this.message = message;
        this.moves = moves;
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

    // Getter for moves
    public List<Move> getMoves() {
        return moves;
    }

    // Setter for moves
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
