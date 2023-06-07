package Manage;

import Function.Create;
import Function.IOFile;
import Function.InputString;
import Model.Customer;

import java.util.List;
import java.util.Scanner;

public class ManageCustomer {
    public static final String Customer_PATH = "C:\\Users\\HDC\\Desktop\\Module2\\Pharmacity\\src\\File\\Customer.dat";
    Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();
    Create create = new Create();
    InputString inputString = new InputString();
    IOFile<Customer> ioFile = new IOFile<>();

    public ManageCustomer() {
    }

    public void displayCustomer() {
        List<Customer> customers = ioFile.readDataFromFile(Customer_PATH);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void addCustomer() {
        List<Customer> customers = ioFile.readDataFromFile(Customer_PATH);
        Customer customer = create.createCustomer(Customer_PATH);
        customers.add(customer);
        ioFile.writeDataToFile(customers, Customer_PATH);
    }

    public int findIndexByUserName(String userName) {
        List<Customer> customers = ioFile.readDataFromFile(Customer_PATH);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserName().equals(userName)) return i;
        }
        return -1;
    }

    public void editCustomer() {
        List<Customer> customers = ioFile.readDataFromFile(Customer_PATH);
        String userName = inputString.inputString("userName", Validate.UserName_PATTERN);
        int index = findIndexByUserName(userName);
        Customer customer = create.createCustomer(Customer_PATH);
        customer.setId(customers.get(index).getId());
        customers.set(index, customer);
        ioFile.writeDataToFile(customers, Customer_PATH);
    }

    public void deleteCustomer() {
        List<Customer> customers = ioFile.readDataFromFile(Customer_PATH);
        String userName = inputString.inputString("userName", Validate.UserName_PATTERN);
        int index = findIndexByUserName(userName);
        customers.remove(index);
        ioFile.writeDataToFile(customers, Customer_PATH);
    }
}
