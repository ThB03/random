package Model;

public class PokemonMove {
    private long id;
    private long pokemonId;
    private long moveId;

    // No-argument constructor
    public PokemonMove() {
    }

    // All-argument constructor
    public PokemonMove(long id, long pokemonId, long moveId) {
        this.id = id;
        this.pokemonId = pokemonId;
        this.moveId = moveId;
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

    // Getter for moveId
    public long getMoveId() {
        return moveId;
    }

    // Setter for moveId
    public void setMoveId(long moveId) {
        this.moveId = moveId;
    }
}
