package Model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private static int countIDMedicine = 1;
    private int id;
    private String name;
    private String type;
    private String effect;
    private String timesUse;
    private int quantity;
    private float price;

    public Medicine(String name, String type, String effect, String timesUse, int quantity, float price) {
        this.id = countIDMedicine++;
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.timesUse = timesUse;
        this.quantity = quantity;
        this.price = price;
    }

    public static int getCountIDMedicine() {
        return countIDMedicine;
    }

    public static void setCountIDMedicine(int countIDMedicine) {
        Medicine.countIDMedicine = countIDMedicine;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getTimesUse() {
        return timesUse;
    }

    public void setTimesUse(String timesUse) {
        this.timesUse = timesUse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public float getToTalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", effect='" + effect + '\'' +
                ", timesUse='" + timesUse + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
