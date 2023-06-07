package manager;

import employee.Employee;

import java.util.Date;

public class Manager extends Employee {
    private final int ROLE = 1;

    public Manager(String userName, String passWord, String name, String gender,
                   Date birthday, String phone, String nativeLand, String nation, String religion) {
        super(userName, passWord, name, gender, birthday, phone, nativeLand, nation, religion);
    }

    public int getROLE() {
        return ROLE;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ROLE=" + ROLE +
                '}';
    }
}
