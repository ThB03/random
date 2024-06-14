package Model;

import java.util.List;

public class SimplePokedex {
    private List<SimplePokedexEntryClass> pokedex;

    // No-argument constructor
    public SimplePokedex() {
    }

    // All-argument constructor
    public SimplePokedex(List<SimplePokedexEntryClass> pokedex) {
        this.pokedex = pokedex;
    }

    // Getter for pokedex
    public List<SimplePokedexEntryClass> getPokedex() {
        return pokedex;
    }

    // Setter for pokedex
    public void setPokedex(List<SimplePokedexEntryClass> pokedex) {
        this.pokedex = pokedex;
    }
}
