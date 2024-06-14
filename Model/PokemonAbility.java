package Model;

public class PokemonAbility {
    private long id;
    private long pokemonId;
    private long abilityId;

    // No-argument constructor
    public PokemonAbility() {
    }

    // All-argument constructor
    public PokemonAbility(long id, long pokemonId, long abilityId) {
        this.id = id;
        this.pokemonId = pokemonId;
        this.abilityId = abilityId;
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

    // Getter for abilityId
    public long getAbilityId() {
        return abilityId;
    }

    // Setter for abilityId
    public void setAbilityId(long abilityId) {
        this.abilityId = abilityId;
    }
}
