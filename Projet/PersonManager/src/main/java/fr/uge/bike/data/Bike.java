package fr.uge.bike.data;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Bike implements Serializable {
    private int id;
    private String brand;
    private String color;
    private int size;

    //Field feeback
    //Field owner

    public Bike() {}

    public Bike(String brand, String color, int size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        //this.feedback = new Feedback();
    }

    public Bike(int id, String brand, String color, int size) {
        this(brand, color, size);
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return brand + " - " + color + ", " + size;
    }
}
