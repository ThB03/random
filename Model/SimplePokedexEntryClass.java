package Model;

public class SimplePokedexEntryClass {
    private long id;
    private String name;
    private String image;

    // No-argument constructor
    public SimplePokedexEntryClass() {
    }

    // All arguments constructor
    public SimplePokedexEntryClass(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    // Constructor with Pokemon parameter
    public SimplePokedexEntryClass(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.image = pokemon.getImage();
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

    // Getter for image
    public String getImage() {
        return image;
    }

    // Setter for image
    public void setImage(String image) {
        this.image = image;
    }
}
