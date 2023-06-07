package Model;

public class Medicine {
    public static int countIDMedicine = 1;
    private int id;
    private String nameMedicine;
    private String typeMedicine;
    private String effect;
    private String timesUse;
    private int quantity;
    private float price;

    public Medicine(String nameMedicine, String typeMedicine, String effect, String timesUse, int quantity, float price) {
        this.id = countIDMedicine++;
        this.nameMedicine = nameMedicine;
        this.typeMedicine = typeMedicine;
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

    public String getNameMedicine() {
        return nameMedicine;
    }

    public void setNameMedicine(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }

    public String getTypeMedicine() {
        return typeMedicine;
    }

    public void setTypeMedicine(String typeMedicine) {
        this.typeMedicine = typeMedicine;
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
                ", nameMedicine='" + nameMedicine + '\'' +
                ", typeMedicine='" + typeMedicine + '\'' +
                ", effect='" + effect + '\'' +
                ", timesUse='" + timesUse + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
