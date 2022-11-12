package fr.eiffel.bike.corp;

public class Bike {
    private final int id;
    private final String brand;
    private final String color;
    private final int size;
    private final Feedback feedback;
    //Field owner

    public Bike(int id, String brand, String color, int size) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.feedback = new Feedback();
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
