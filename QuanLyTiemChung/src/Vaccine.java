import java.util.Date;

public class Vaccine {
    public static int countIDVaccine = 1;
    private int id;
    private String name;
    private float price;
    private Date dateVaccine;
    private Date injectVaccine;

    public Vaccine(String name, float price, Date dateVaccine, Date injectVaccine) {
        this.id = countIDVaccine++;
        this.name = name;
        this.price = price;
        this.dateVaccine = dateVaccine;
        this.injectVaccine = injectVaccine;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDateVaccine() {
        return dateVaccine;
    }

    public void setDateVaccine(Date dateVaccine) {
        this.dateVaccine = dateVaccine;
    }

    public Date getInjectVaccine() {
        return injectVaccine;
    }

    public void setInjectVaccine(Date injectVaccine) {
        this.injectVaccine = injectVaccine;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateVaccine=" + dateVaccine +
                ", injectVaccine=" + injectVaccine +
                '}';
    }
}
