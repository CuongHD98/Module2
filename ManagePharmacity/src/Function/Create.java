package Function;

import File.FilePATH;
import Manage.ManageCustomer;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create {
    Input input = new Input();
    IOFile<Medicine> ioFileM = new IOFile<>();
    IOFile<Account> ioFileA = new IOFile<>();
    IOFile<Customer> ioFileC = new IOFile<>();
    Scanner scanner = new Scanner(System.in);

    public Medicine medicine() {
        List<Medicine> medicines = ioFileM.readDataFromFile(FilePATH.Medicine_PATH);
        String name = input.inputDuplicatedNameMedicine(medicines);
        String type = input.inputString("type", Validate.TypeMedicine_PATTERN);
        String effect = input.inputString("effect", Validate.EffectMedicine_PATTERN);
        String timesUse = input.inputString("timesUse", Validate.TimesUseMedicine_PATTERN);
        int quantity = input.inputInt("quantity", Validate.INT_PATTERN);
        float price = input.inputFloat("price", Validate.Price_PATTERN);
        return new Medicine(name, type, effect, timesUse, quantity, price);
    }

    public Person person() {
        String name = input.inputString("name", Validate.Name_PATTERN);
        String gender = input.inputString("gender", Validate.Gender_PATTERN);
        String birthday = input.inputString("birthday", Validate.Birthday_PATTERN);
        String phone = input.inputString("phone", Validate.Phone_PATTERN);
        String email = input.inputString("email", Validate.Email_PATTERN);
        return new Person(name, gender, birthday, phone, email);
    }

    public Account account() {
        List<Account> accounts = ioFileA.readDataFromFile(FilePATH.Account_PATH);
        Person person = person();
        String username = input.inputDuplicatedUserName(accounts);
        String password = input.inputString("password", Validate.PassWord_PATTERN);
        String ROLE = input.inputString("ROLE", Validate.ROLE_PATTERN);
        return new Account(person.getName(), person.getGender(), person.getBirthday(), person.getPhone(), person.getEmail(),
                username, password, ROLE);
    }

    public Manager manager() {
        Account account = account();
        Account.setCountIDAccount(Account.getCountIDAccount() - 1);
        return new Manager(account.getName(), account.getGender(), account.getBirthday(), account.getPhone(), account.getEmail(),
                account.getUsername(), account.getPassword(), account.getROLE());
    }

    public Pharmacist pharmacist() {
        Manager manager = manager();
        int daysOn = input.inputInt("daysOn", Validate.INT_PATTERN);
        Account.setCountIDAccount(Account.getCountIDAccount()-1);
        return new Pharmacist(manager.getName(), manager.getGender(), manager.getBirthday(), manager.getPhone(), manager.getEmail(),
                manager.getUsername(), manager.getPassword(), manager.getROLE(), daysOn);
    }

    public Customer customer() {
        Person person = person();
        return new Customer(person.getName(), person.getGender(), person.getBirthday(), person.getPhone(), person.getEmail());
    }
    public Order order(Account account) {
        while (true) {
            System.out.println("Menu CreateOrder : ");
            System.out.println("1. Old Customer");
            System.out.println("2. New Customer");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    ManageCustomer manageCustomer = new ManageCustomer();
                    String name = input.inputString("name", Validate.Name_PATTERN);
                    Customer customer = manageCustomer.findCustomerByName(name);
                    if (customer != null) {
                        List<Medicine> medicines = new ArrayList<>();
                        return new Order(account, customer, medicines);
                    } else System.out.println("Not found NameOldCustomer!");
                case "2":
                    List<Customer> customers = ioFileC.readDataFromFile(FilePATH.Customer_PATH);
                    Customer newCustomer = customer();
                    customers.add(newCustomer);
                    ioFileC.writeDataToFile(customers, FilePATH.Customer_PATH);
                    List<Medicine> medicines = new ArrayList<>();
                    return new Order(account, newCustomer, medicines);
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}
