package Model;

import java.util.List;

public class Order {
    private static int countIDOrder = 1;
    private int id;
    List<Medicine> medicines;
    Manager manager;
    Customer customer;
    float billMoney;

    public Order(List<Medicine> medicines, Manager manager, Customer customer) {
        this.id = countIDOrder++;
        this.medicines = medicines;
        this.manager = manager;
        this.customer = customer;
        float billMoney = 0;
        for (Medicine medicine : medicines) {
            billMoney += medicine.getToTalPrice();
        }
        this.billMoney = billMoney;
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

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Pharmacits pharmacits) {
        this.manager = pharmacits;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(float billMoney) {
        this.billMoney = billMoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", medicines=" + medicines +
                ", manager=" + manager +
                ", customer=" + customer +
                ", billMoney=" + billMoney +
                '}';
    }
}
