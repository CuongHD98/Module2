import java.util.ArrayList;
import java.util.List;

public class Customer {
    public static int countIDCustomer = 1;
    private int id;
    private String name;
    private String phone;
    private List<Vaccine> listVaccine = new ArrayList<>();

    public Customer(String name, String phone, List<Vaccine> listVaccine) {
        this.id = countIDCustomer++;
        this.name = name;
        this.phone = phone;
        this.listVaccine = listVaccine;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vaccine> getListVaccine() {
        return listVaccine;
    }

    public void setListVaccine(List<Vaccine> listVaccine) {
        this.listVaccine = listVaccine;
    }

    public void addVaccine(Vaccine vaccine) {
        this.listVaccine.add(vaccine);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", listVaccine=" + listVaccine +
                '}';
    }
}
