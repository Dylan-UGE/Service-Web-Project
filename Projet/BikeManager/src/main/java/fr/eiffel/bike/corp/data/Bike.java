package fr.eiffel.bike.corp.data;

public class Bike {
    private final int id;
    private final String brand;
    private final String color;
    private final int size;

    //Field owner

    public Bike(int id, String brand, String color, int size) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
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
