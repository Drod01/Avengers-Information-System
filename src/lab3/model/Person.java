package lab3.model;

public abstract class Person {
    private String name;
    private int heightFeet;
    private int heightInches;
    private int weight;

    public Person(String name, int heightFeet, int heightInches, int weight) {
        this.name = name;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }
}