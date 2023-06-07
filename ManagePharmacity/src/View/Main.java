package View;

import File.FilePATH;
import Function.IOFile;
import Function.Input;
import Function.LastStaticCountID;
import Manage.*;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Input input = new Input();
    public static Login login = new Login();
    public static ManageAccount manageAccount = new ManageAccount();
    public static ManageCustomer manageCustomer = new ManageCustomer();
    public static ManageMedicine manageMedicine = new ManageMedicine();
    public static ManageOrder manageOrder = new ManageOrder();
    public static IOFile<LastStaticCountID> ioFile = new IOFile<>();

    public static void main(String[] args) {
        List<LastStaticCountID> lastStaticCountID = ioFile.readDataFromFile(FilePATH.CountID_PATH);
        if (lastStaticCountID.size() > 0) {
            Account.setCountIDAccount(lastStaticCountID.get(0).getLastIDAccount());
            Customer.setCountIDCustomer(lastStaticCountID.get(0).getLastIDCustomer());
            Medicine.setCountIDMedicine(lastStaticCountID.get(0).getLastIDMedicine());
            Order.setCountIDOrder(lastStaticCountID.get(0).getLastIDOrder());
        }
        menuLogin();
    }

    public static void menuLogin() {
        while (true) {
            System.out.println("----------Menu Login----------");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Account account = login.login();
                    if (account != null) {
                        if (account.getROLE().equals("ADMIN")) {
                            menuAdmin(account);
                        }
                        if (account.getROLE().equals("USER")) {
                            menuUser(account);
                        }
                    }
                    break;
                case "2":
                    List<LastStaticCountID> lastStaticCountIDs = new ArrayList<>();
                    LastStaticCountID lastStaticCountID = new LastStaticCountID();
                    lastStaticCountID.setLastIDAccount(Account.getCountIDAccount());
                    lastStaticCountID.setLastIDCustomer(Customer.getCountIDCustomer());
                    lastStaticCountID.setLastIDMedicine(Medicine.getCountIDMedicine());
                    lastStaticCountID.setLastIDOrder(Order.getCountIDOrder());
                    lastStaticCountIDs.add(lastStaticCountID);
                    ioFile.writeDataToFile(lastStaticCountIDs, FilePATH.CountID_PATH);
                    System.exit(0);
                default:
                    System.out.println("Not found Choice!");
            }

        }
    }

    public static void menuAdmin(Account account) {
        while (true) {
            System.out.println("-----Menu Admin-----");
            System.out.println("1. Manage Account");
            System.out.println("2. Manage Medicine");
            System.out.println("3. Manage Order");
            System.out.println("4. Manage Customer");
            System.out.println("5. LogOut ");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    menuManageAccount();
                    break;
                case "2":
                    menuManageMedicine();
                    break;
                case "3":
                    menuManageOrder(account);
                    break;
                case "4":
                    menuManageCustomer();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public static void menuUser(Account account) {
        while (true) {
            System.out.println("-----Menu User-----");
            System.out.println("1. Manage Order");
            System.out.println("2. Manage Customer");
            System.out.println("3. CheckIn");
            System.out.println("4. LogOut");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    menuManageOrder(account);
                    break;
                case "2":
                    menuManageCustomer();
                    break;
                case "3":
                    manageAccount.checkIn(account);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public static void menuManageAccount() {
        while (true) {
            System.out.println("-----Menu ManageAccount-----");
            System.out.println("1. Display Account");
            System.out.println("2. Add Account");
            System.out.println("3. Edit Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Find Account");
            System.out.println("6. Salary Payment");
            System.out.println("7. Exit ManageAccount");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageAccount.displayAccount();
                    break;
                case "2":
                    manageAccount.addAccount();
                    break;
                case "3":
                    manageAccount.editAccount();
                    break;
                case "4":
                    manageAccount.deleteAccount();
                    break;
                case "5":
                    String username = input.inputString("username", Validate.UserName_PATTERN);
                    Account account = manageAccount.findAccount(username);
                    if (account != null) {
                        if (account.getROLE().equals("ADMIN")) {
                            System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%s",
                                    "ID", "Name", "Gender", "Birthday", "Phone", "Email", "Username", "Password", "ROLE", "\n");
                            System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%s",
                                    account.getId(), account.getName(), account.getGender(), account.getBirthday(), account.getPhone(),
                                    account.getEmail(), account.getUsername(), account.getPassword(), account.getROLE(), "\n");
                        } else {
                            System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%-10s%s",
                                    "ID", "Name", "Gender", "Birthday", "Phone", "Email", "DaysOn", "Username", "Password", "ROLE", "\n");
                            System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%-10s%s",
                                    account.getId(), account.getName(), account.getGender(), account.getBirthday(), account.getPhone(),
                                    account.getEmail(), ((Pharmacist) account).getDaysOn(),
                                    account.getUsername(), account.getPassword(), account.getROLE(), "\n");
                        }
                    } else System.out.println("Not found Username!");
                    break;
                case "6":
                    manageAccount.salaryPayment();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public static void menuManageMedicine() {
        while (true) {
            System.out.println("-----Menu ManageMedicine-----");
            System.out.println("1. Display Medicine");
            System.out.println("2. Add Medicine");
            System.out.println("3. Edit Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("5. Find Medicine");
            System.out.println("6. Exit ManageMedicine");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageMedicine.displayMedicine();
                    break;
                case "2":
                    manageMedicine.addMedicine();
                    break;
                case "3":
                    manageMedicine.editMedicine();
                    break;
                case "4":
                    manageMedicine.deleteMedicine();
                    break;
                case "5":
                    String nameMedicine = input.inputString("nameMedicine", Validate.NameMedicine_PATTERN);
                    Medicine medicine = manageMedicine.findMedicineByName(nameMedicine);
                    if (medicine != null) {
                        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                                "ID", "Name", "Type", "Effect", "TimesUse", "Quantity", "Price", "\n");
                        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                                medicine.getId(), medicine.getName(), medicine.getType(), medicine.getEffect(),
                                medicine.getTimesUse(), medicine.getQuantity(), medicine.getPrice(), "\n");
                    } else System.out.println("Not found NameMedicine!");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public static void menuManageOrder(Account account) {
        while (true) {
            System.out.println("-----Menu ManageOrder-----");
            System.out.println("1. Display Medicines");
            System.out.println("2. Display Order");
            System.out.println("3. Add Order");
            System.out.println("4. Edit Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Find Order");
            System.out.println("7. Exit ManageOrder");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageMedicine.displayMedicine();
                    break;
                case "2":
                    manageOrder.displayOrder();
                    break;
                case "3":
                    manageOrder.addOrder(account);
                    break;
                case "4":
                    manageOrder.editOrder(account);
                    break;
                case "5":
                    manageOrder.deleteOrder(account);
                    break;
                case "6":
                    int id = input.inputInt("id", Validate.INT_PATTERN);
                    Order order = manageOrder.findOrderByID(id);
                    if (order != null) {
                        System.out.printf("%-5s%-20s%-15s%-15s%-15s%-26s%s",
                                "ID", "ROLE | NameAccount", "NameCustomer", "Birthday", "Phone", "Email", "\n");
                        System.out.printf("%-5s%-20s%-15s%-15s%-15s%-26s%s", order.getId(), order.getAccount().getROLE() + " | " + order.getAccount().getName(),
                                order.getCustomer().getName(), order.getCustomer().getBirthday(),
                                order.getCustomer().getPhone(), order.getCustomer().getEmail(), "\n");
                        System.out.println("---ListMedicineBuy---");
                        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%-10s%s",
                                "ID", "Name", "Type", "Effect", "TimesUse", "Quantity", "Price", "TotalPrice", "\n");
                        for (Medicine medicine : order.getMedicines()) {
                            System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%-10s%s",
                                    medicine.getId(), medicine.getName(), medicine.getType(), medicine.getEffect(),
                                    medicine.getTimesUse(), medicine.getQuantity(), medicine.getPrice(), medicine.getToTalPrice(), "\n");
                        }
                        System.out.println("===>> TotalMoneyOrder: " + order.getTotalMoney());
                    } else System.out.println("Not found ID!");
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public static void menuManageCustomer() {
        while (true) {
            System.out.println("-----Menu ManageCustomer-----");
            System.out.println("1. Display Customer");
            System.out.println("2. Add Customer");
            System.out.println("3. Edit Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Find Customer");
            System.out.println("6. Exit ManageCustomer");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageCustomer.displayCustomer();
                    break;
                case "2":
                    manageCustomer.addCustomer();
                    break;
                case "3":
                    manageCustomer.editCustomer();
                    break;
                case "4":
                    manageCustomer.deleteCustomer();
                    break;
                case "5":
                    String name = input.inputString("name", Validate.Name_PATTERN);
                    Customer customer = manageCustomer.findCustomerByName(name);
                    if (customer != null) {
                        System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%s",
                                "ID", "Name", "Gender", "Birthday", "Phone", "Email", "\n");
                        System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%s",
                                customer.getId(), customer.getName(), customer.getGender(), customer.getBirthday(),
                                customer.getPhone(), customer.getEmail(), "\n");
                    } else System.out.println("Not found NameCustomer!");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}
