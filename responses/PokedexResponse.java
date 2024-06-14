package responses;

import Model.Pokedex;

public class PokedexResponse {
    private int status;
    private String message;
    private Pokedex pokedex;

    // Default constructor
    public PokedexResponse() {
    }

    // All-args constructor
    public PokedexResponse(int status, String message, Pokedex pokedex) {
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
    public Pokedex getPokedex() {
        return pokedex;
    }

    // Setter for pokedex
    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }
}
