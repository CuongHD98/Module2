package Model;

public class Pharmacits extends Manager {
    private final int ROLE = 2;
    private final int SALARY = 500000;
    private int daysOn;
    private int daysOff;
    private int timesCheckInLate;
    private int timesCheckOutSoon;

    public Pharmacits(String userName, String passWord, String name, String gender,
                      String birthDay, String phone, String email, int daysOn, int daysOff,
                      int timesCheckInLate, int timesCheckOutSoon) {
        super(userName, passWord, name, gender, birthDay, phone, email);
        this.daysOn = daysOn;
        this.daysOff = daysOff;
        this.timesCheckInLate = timesCheckInLate;
        this.timesCheckOutSoon = timesCheckOutSoon;
    }

    public int getROLE() {
        return ROLE;
    }

    public int getSALARY() {
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

    public int getToTalSalary() {
        daysOff += timesCheckInLate / 3 + timesCheckOutSoon / 3;
        return SALARY * (daysOn - daysOff);
    }

    @Override
    public String toString() {
        return "Pharmacits{" +
                "ROLE=" + ROLE +
                ", SALARY=" + SALARY +
                ", daysOn=" + daysOn +
                ", daysOff=" + daysOff +
                ", timesCheckInLate=" + timesCheckInLate +
                ", timesCheckOutSoon=" + timesCheckOutSoon +
                '}';
    }
}
