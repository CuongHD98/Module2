package Model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private static int countIDOrder = 1;
    private int id;
    private Account account;
    private Customer customer;
    private List<Medicine> medicines;
    private float totalMoney;

    public Order(Account account, Customer customer, List<Medicine> medicines) {
        this.id = countIDOrder++;
        this.account = account;
        this.customer = customer;
        this.medicines = medicines;
        this.totalMoney = 0;
        for (Medicine medicine : medicines) {
            this.totalMoney += medicine.getToTalPrice();
        }
    }

    public static int getCountIDOrder() {
        return countIDOrder;
    }

    public static void setCountIDOrder(int countIDOrder) {
        Order.countIDOrder = countIDOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addMedicine(Medicine medicine) {
        this.medicines.add(medicine);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", account=" + account +
                ", customer=" + customer +
                ", medicines=" + medicines +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
