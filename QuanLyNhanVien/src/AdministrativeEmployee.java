import java.util.Date;

public class AdministrativeEmployee extends Employee {
    private int daysOff;

    public AdministrativeEmployee(int daysOff) {
        this.daysOff = daysOff;
    }

    public AdministrativeEmployee(String name, Date birthday, int salary, int daysOn, int daysOff) {
        super(name, birthday, salary, daysOn);
        this.daysOff = daysOff;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int calculateMonthlySalary() {
        return 500*(super.getDaysOn() - this.getDaysOff());
    }

    @Override
    public String toString() {
        return "AdministrativeEmployee{" +
                "daysOff=" + daysOff +
                '}' + super.toString();
    }
}
