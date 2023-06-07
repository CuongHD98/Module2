package Model;

public class Manager extends Person {
    private final int ROLE = 1;

    public Manager(String userName, String passWord, String name, String gender, String birthDay, String phone, String email) {
        super(userName, passWord, name, gender, birthDay, phone, email);
    }

    public int getROLE() {
        return ROLE;
    }

}
