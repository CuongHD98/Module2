package personnel;

import java.util.Date;

import payroll.payroll;

public class PartTime extends Personnel implements payroll {
    private int timeWork;

    public PartTime() {
    }

    public PartTime(int timeWork) {
        this.timeWork = timeWork;
    }

    public PartTime(String name, String phone, Date birthday, int timeWork) {
        super(name, phone, birthday);
        this.timeWork = timeWork;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }

    @Override
    public double workMoney() {
        return timeWork * 30000;
    }

    @Override
    public String toString() {
        return
                "{ID : " + super.getId() +
                        " PartTime " +
                        " Name : " + super.getName() +
                        " Phone : " + super.getPhone() +
                        " Birthday : " + super.getBirthday() +
                        " TimeWork : " + getTimeWork() +
                        "}";
    }
}
