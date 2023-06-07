package employee;

import account.Account;

import java.util.Date;

public class Employee extends Account {
    private static int countIDEmployee = 1;
    private int id;
    private String name;
    private String gender;
    private Date birthday;
    private String phone;
    private String nativeLand;
    private String nation;
    private String religion;

    public Employee(String userName, String passWord, String name, String gender,
                    Date birthday, String phone, String nativeLand, String nation, String religion) {
        super(userName, passWord);
        this.id = countIDEmployee++;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.nativeLand = nativeLand;
        this.nation = nation;
        this.religion = religion;
    }

    public static int getCountIDEmployee() {
        return countIDEmployee;
    }

    public static void setCountIDEmployee(int countIDEmployee) {
        Employee.countIDEmployee = countIDEmployee;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNativeLand() {
        return nativeLand;
    }

    public void setNativeLand(String nativeLand) {
        this.nativeLand = nativeLand;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", nativeLand='" + nativeLand + '\'' +
                ", nation='" + nation + '\'' +
                ", religion='" + religion + '\'' +
                '}';
    }
}
