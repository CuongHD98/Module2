package Model;

public class Customer extends Person {
    private final int ROLE = 3;

    public Customer(String userName, String passWord, String name, String gender, String birthDay, String phone, String email) {
        super(userName, passWord, name, gender, birthDay, phone, email);
    }

    public int getROLE() {
        return ROLE;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ROLE=" + ROLE +
                '}';
    }
}
