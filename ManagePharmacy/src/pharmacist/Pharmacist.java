package pharmacist;

import employee.Employee;

import java.util.Date;

public class Pharmacist extends Employee {
    private final int ROLE = 0;
    private final float SALARY = 500000;
    private int daysOn;
    private int daysOff;
    private int timesCheckInLate;
    private int timesCheckOutSoon;

    public Pharmacist(String userName, String passWord, String name, String gender,
                      Date birthday, String phone, String nativeLand, String nation, String religion,
                      int daysOn, int daysOff, int timesCheckInLate, int timesCheckOutSoon) {
        super(userName, passWord, name, gender, birthday, phone, nativeLand, nation, religion);
        this.daysOn = daysOn;
        this.daysOff = daysOff;
        this.timesCheckInLate = timesCheckInLate;
        this.timesCheckOutSoon = timesCheckOutSoon;
    }

    public int getROLE() {
        return ROLE;
    }

    public float getSALARY() {
        return SALARY;
    }

    public int getDaysOn() {
        return daysOn;
    }

    public void setDaysOn(int daysOn) {
        this.daysOn = daysOn;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int getTimesCheckInLate() {
        return timesCheckInLate;
    }

    public void setTimesCheckInLate(int timesCheckInLate) {
        this.timesCheckInLate = timesCheckInLate;
    }

    public int getTimesCheckOutSoon() {
        return timesCheckOutSoon;
    }

    public void setTimesCheckOutSoon(int timesCheckOutSoon) {
        this.timesCheckOutSoon = timesCheckOutSoon;
    }

    public float getTotalSalary() {
        return SALARY * (daysOn - daysOff);
    }

    @Override
    public String toString() {
        return "Pharmacist{" +
                "ROLE=" + ROLE +
                ", SALARY=" + SALARY +
                ", daysOn=" + daysOn +
                ", daysOff=" + daysOff +
                ", timesCheckInLate=" + timesCheckInLate +
                ", timesCheckOutSoon=" + timesCheckOutSoon +
                '}';
    }
}
