package fr.uge.bike.data;

import java.io.Serializable;
import java.util.Objects;

public class Bike implements Serializable {
    private int id;
    private String brand;
    private String color;
    private int size;
    private int price;

    public Bike() {}

    public Bike(String brand, String color, int size, int price) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Bike(int id, String brand, String color, int size, int price) {
        this(brand, color, size, price);
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
    
    public int getPrice() {
        return price;
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
    
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " - " + color + ", " + size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, size, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return id == bike.id && size == bike.size && price == bike.price && Objects.equals(brand, bike.brand) && Objects.equals(color, bike.color);
    }
}
