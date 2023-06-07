package ID9289;

import java.io.*;
import java.util.*;

class Product implements Serializable {
    private String name;
    private int id;
    private double price;

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " (ID: " + id + ", Price: $" + price + ")";
    }
}
