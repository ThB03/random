package Model;

public class Ability {
    private long id;
    private String name;
    private String effect;

    // No-argument constructor
    public Ability() {
    }

    // All-argument constructor
    public Ability(long id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for effect
    public String getEffect() {
        return effect;
    }

    // Setter for effect
    public void setEffect(String effect) {
        this.effect = effect;
    }
}
