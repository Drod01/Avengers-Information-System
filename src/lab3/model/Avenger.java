package lab3.model;

public class Avenger extends Person {
    private String alias;
    private String location;
    private boolean hasPowers;

    public Avenger(String name, int heightFeet, int heightInches, int weight, String alias, String location, boolean hasPowers) {
        super(name, heightFeet, heightInches, weight);
        this.alias = alias;
        this.location = location;
        this.hasPowers = hasPowers;
    }

    public String getAlias() {
        return alias;
    }

    public String getLocation() {
        return location;
    }

    public boolean hasPowers() {
        return hasPowers;
    }

    public String toString() {
        return super.toString() + " (" + alias + ")";
    }
}