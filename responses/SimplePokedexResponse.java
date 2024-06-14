package responses;

import Model.SimplePokedex;

public class SimplePokedexResponse {
    private int status;
    private String message;
    private SimplePokedex pokedex;

    // Default constructor
    public SimplePokedexResponse() {
    }

    // All-args constructor
    public SimplePokedexResponse(int status, String message, SimplePokedex pokedex) {
        this.status = status;
        this.message = message;
        this.pokedex = pokedex;
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

    // Getter for pokedex
    public SimplePokedex getPokedex() {
        return pokedex;
    }

    // Setter for pokedex
    public void setPokedex(SimplePokedex pokedex) {
        this.pokedex = pokedex;
    }
}
