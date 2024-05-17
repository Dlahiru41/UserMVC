package entities;

public class Movie {
    private int id;
    private String name;
    private int length; // Assuming movie length is in minutes

    // Constructor
    public Movie(int id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
