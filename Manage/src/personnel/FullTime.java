package personnel;

import payroll.Payroll;
import work.TypeWork;
import java.util.Date;

public class FullTime extends Personnel implements Payroll, TypeWork {
    private float coefficient;

    public FullTime() {
    }

    public FullTime(float coefficient) {
        this.coefficient = coefficient;
    }

    public FullTime(String name, String phone, Date birthday, float coefficient) {
        super(name, phone, birthday);
        this.coefficient = coefficient;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String getTypeWork() {
        return "FullTime";
    }


    @Override
    public double workMoney() {
        return coefficient * 3000000;
    }

    @Override
    public String toString() {
        return
                "{ID : " + super.getId() + " - " +
                        " FullTime " + " - " +
                        " Name : " + super.getName() + " - " +
                        " Phone : " + super.getPhone() + " - " +
                        " Birthday : " + super.getBirthday() + " - " +
                        " Coefficient : " + getCoefficient() +
                        "}";
    }
}
