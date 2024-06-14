package Model;

import java.util.List;

public class Pokedex {
    private List<PokedexEntryClass> pokedex;

    // No-argument constructor
    public Pokedex() {
    }

    // All-argument constructor
    public Pokedex(List<PokedexEntryClass> pokedex) {
        this.pokedex = pokedex;
    }

    // Getter for pokedex
    public List<PokedexEntryClass> getPokedex() {
        return pokedex;
    }

    // Setter for pokedex
    public void setPokedex(List<PokedexEntryClass> pokedex) {
        this.pokedex = pokedex;
    }
}
