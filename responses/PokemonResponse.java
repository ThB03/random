package responses;

import Model.PokemonClass;

public class PokemonResponse {
    private int status;
    private String message;
    private PokemonClass pokemon;

    // Default constructor
    public PokemonResponse() {
    }

    // All-args constructor
    public PokemonResponse(int status, String message, PokemonClass pokemon) {
        this.status = status;
        this.message = message;
        this.pokemon = pokemon;
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

    // Getter for pokemon
    public PokemonClass getPokemon() {
        return pokemon;
    }

    // Setter for pokemon
    public void setPokemon(PokemonClass pokemon) {
        this.pokemon = pokemon;
    }
}
