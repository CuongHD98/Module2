import java.io.Serializable;
import java.util.Date;

public class TechnicalEmployee extends Employee {
    private int projects;

    public TechnicalEmployee(int projects) {
        this.projects = projects;
    }

    public TechnicalEmployee(String name, Date birthday, int salary, int daysOn, int projects) {
        super(name, birthday, salary, daysOn);
        this.projects = projects;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }

    public int calculateMonthlySalary() {
        return 500 * super.getDaysOn() + 200 * this.projects;
    }

    @Override
    public String toString() {
        return "TechnicalEmployee{" +
                "projects=" + projects +
                '}' + super.toString();
    }
}
