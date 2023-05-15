package personnel;

import work.TypeWork;

import java.util.Date;

import payroll.Payroll;

public class Personnel implements Payroll, TypeWork, Comparable<Personnel> {
    private int id;
    private String name;
    private String phone;
    private Date birthday;
    static int count = 1;

    public Personnel() {
    }

    public Personnel(String name, String phone, Date birthday) {
        this.id = count;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        count++;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public double workMoney() {
        return 0;
    }

    @Override
    public String getTypeWork() {
        return null;
    }

    @Override
    public int compareTo(Personnel o) {
        return this.id - o.getId();
    }

    @Override
    public String toString() {
        return null;
    }
}
