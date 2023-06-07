import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    public static int count = 1;
    private int id;
    private String name;
    private Date birthday;
    private int salary;
    private int daysOn;

    public Employee() {
    }

    public Employee(String name, Date birthday, int salary, int daysOn) {
        this.id = count++;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.daysOn = daysOn;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDaysOn() {
        return daysOn;
    }

    public void setDaysOn(int daysOn) {
        this.daysOn = daysOn;
    }

    public int calculateMonthlySalary() {
        return this.salary * daysOn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", daysOn=" + daysOn +
                '}';
    }
}