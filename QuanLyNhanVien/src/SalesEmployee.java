import java.util.Date;

public class SalesEmployee extends Employee{
    private int sales;

    public SalesEmployee(int sales) {
        this.sales = sales;
    }

    public SalesEmployee(String name, Date birthday, int salary, int daysOn, int sales) {
        super(name, birthday, salary, daysOn);
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int calculateMonthlySalary() {
        return 300 * super.getDaysOn() + 50 * this.sales;
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "sales=" + sales +
                '}' + super.toString();
    }
}
