package fr.uge.bike.data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bike implements Serializable {
    private int id;
    private String brand;
    private String color;
    private List<Feedback> feedbacks;
    private int size;

    //Field feeback
    //Field owner

    public Bike() {}

    public Bike(String brand, String color, int size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.feedbacks = new ArrayList<Feedback>();
    }

    public Bike(int id, String brand, String color, int size) {
        this(brand, color, size);
        this.id = id;
    }

    public double average(){
        return feedbacks.stream().mapToInt(Feedback::getScore).average().getAsDouble();
    }


    /*public Map<User, String> comments(){
        return  feedbacks.stream().collect(Collectors.toMap(feedback => ))
    }*/

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
