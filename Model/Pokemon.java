package Model;

public class Pokemon {
    private long id;
    private String name;
    private String image;
    private long total;
    private long hp;
    private long attack;
    private long defense;
    private long spAtt;
    private long spDef;
    private long speed;
    private String flavor;

    // No-argument constructor
    public Pokemon() {
    }

    // All-argument constructor
    public Pokemon(long id, String name, String image, long total, long hp, long attack, long defense, long spAtt, long spDef, long speed, String flavor) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtt = spAtt;
        this.spDef = spDef;
        this.speed = speed;
        this.flavor = flavor;
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

    // Getter for total
    public long getTotal() {
        return total;
    }

    // Setter for total
    public void setTotal(long total) {
        this.total = total;
    }

    // Getter for hp
    public long getHp() {
        return hp;
    }

    // Setter for hp
    public void setHp(long hp) {
        this.hp = hp;
    }

    // Getter for attack
    public long getAttack() {
        return attack;
    }

    // Setter for attack
    public void setAttack(long attack) {
        this.attack = attack;
    }

    // Getter for defense
    public long getDefense() {
        return defense;
    }

    // Setter for defense
    public void setDefense(long defense) {
        this.defense = defense;
    }

    // Getter for spAtt
    public long getSpAtt() {
        return spAtt;
    }

    // Setter for spAtt
    public void setSpAtt(long spAtt) {
        this.spAtt = spAtt;
    }

    // Getter for spDef
    public long getSpDef() {
        return spDef;
    }

    // Setter for spDef
    public void setSpDef(long spDef) {
        this.spDef = spDef;
    }

    // Getter for speed
    public long getSpeed() {
        return speed;
    }

    // Setter for speed
    public void setSpeed(long speed) {
        this.speed = speed;
    }

    // Getter for flavor
    public String getFlavor() {
        return flavor;
    }

    // Setter for flavor
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
