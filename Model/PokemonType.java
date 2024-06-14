package Model;

public class PokemonType {
    private long id;
    private long pokemonId;
    private String type;

    // No-argument constructor
    public PokemonType() {
    }

    // All-argument constructor
    public PokemonType(long id, long pokemonId, String typeId) {
        this.id = id;
        this.pokemonId = pokemonId;
        this.type = typeId;
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for pokemonId
    public long getPokemonId() {
        return pokemonId;
    }

    // Setter for pokemonId
    public void setPokemonId(long pokemonId) {
        this.pokemonId = pokemonId;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }
}
