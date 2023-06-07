package Manage;

import Function.Create;
import Function.IOFile;
import Function.InputString;
import Model.Account;
import Model.Customer;
import Model.Manager;
import Model.Order;

import java.util.List;
import java.util.Scanner;

public class ManageOrder {
    public static final String Order_PATH = "C:\\Users\\HDC\\Desktop\\Module2\\Pharmacity\\src\\File\\Order.dat";
    Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();
    Create create = new Create();
    InputString inputString = new InputString();
    IOFile<Order> ioFileO = new IOFile<>();
    IOFile<Customer> ioFileC = new IOFile<>();
    ManageCustomer manageCustomer = new ManageCustomer();
    ManageMedicine manageMedicine = new ManageMedicine();

    public ManageOrder(Manager manager) {
    }

    public void displayOrder() {
        List<Order> orders = ioFileO.readDataFromFile(Order_PATH);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public void addOrder() {
        while (true) {
            System.out.println("Menu addOrder:");
            System.out.println("1. Old Customer");
            System.out.println("2. New Customer");
            System.out.println("3. Exit addOrder");
            System.out.println("Enter choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Customer> customers = ioFileC.readDataFromFile(ManageCustomer.Customer_PATH);
                    String userName = inputString.inputString("userName", Validate.UserName_PATTERN);
                    int index = manageCustomer.findIndexByUserName(userName);
                    Customer customer = customers.get(index);


                case "2":
                    Customer newCustomer = create.createCustomer(ManageCustomer.Customer_PATH);
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}
