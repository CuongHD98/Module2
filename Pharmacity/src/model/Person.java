package Model;

public class Person extends Account {
    private static int countIDPerson = 1;
    private int id;
    private String name;
    private String gender;
    private String birthDay;
    private String phone;
    private String email;

    public Person(String userName, String passWord, String name, String gender, String birthDay, String phone, String email) {
        super(userName, passWord);
        this.id = countIDPerson++;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
    }

    public int getROLE() {
        return 0;
    }

    public static int getCountIDPerson() {
        return countIDPerson;
    }

    public static void setCountIDPerson(int countIDPerson) {
        Person.countIDPerson = countIDPerson;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
