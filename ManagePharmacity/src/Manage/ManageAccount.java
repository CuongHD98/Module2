package Manage;

import File.FilePATH;
import Function.Create;
import Function.IOFile;
import Function.Input;
import Model.*;

import java.util.List;
import java.util.Scanner;

public class ManageAccount {
    Scanner scanner = new Scanner(System.in);
    Create create = new Create();
    Input input = new Input();
    IOFile<Account> ioFile = new IOFile<>();

    public ManageAccount() {
        //check account Admin
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        boolean isHasAdminAccount = false;
        for (Account account : accounts) {
            if (account.getUsername().equals("Admin")) {
                isHasAdminAccount = true;
                break;
            }
        }
        if (!isHasAdminAccount) {
            Manager manager = new Manager("Admin", "Male", "1/1/1111", "0987654321",
                    "Admin@gmail.com", "Admin", "Admin", "ADMIN");
            accounts.add(manager);
            ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
        }
    }

    public int findIndexByUserName(String username) {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void displayAccount() {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        System.out.println("-------------------AccountManager-------------------");
        System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%s",
                "ID", "Name", "Gender", "Birthday", "Phone", "Email", "Username", "Password", "ROLE", "\n");
        for (Account account : accounts) {
            if (account.getROLE().equals("ADMIN")) {
                System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%s",
                        account.getId(), account.getName(), account.getGender(), account.getBirthday(), account.getPhone(),
                        account.getEmail(), account.getUsername(), account.getPassword(), account.getROLE(), "\n");
            }
        }
        System.out.println("-------------------AccountPharmacist-------------------");
        System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%-10s%s",
                "ID", "Name", "Gender", "Birthday", "Phone", "Email", "DaysOn", "Username", "Password", "ROLE", "\n");
        for (Account account : accounts) {
            if (account.getROLE().equals("USER")) {
                System.out.printf("%-5s%-10s%-10s%-13s%-15s%-26s%-10s%-10s%-10s%-10s%s",
                        account.getId(), account.getName(), account.getGender(), account.getBirthday(), account.getPhone(),
                        account.getEmail(), ((Pharmacist) account).getDaysOn(),
                        account.getUsername(), account.getPassword(), account.getROLE(), "\n");
            }
        }
    }

    public void addAccount() {
        while (true) {
            List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
            System.out.println("Menu Register : ");
            System.out.println("1. Register Manager");
            System.out.println("2. Register Pharmacist");
            System.out.println("3. Exit Register");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Manager manager = create.manager();
                    accounts.add(manager);
                    ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
                    System.out.println("Register Success");
                    break;
                case "2":
                    Pharmacist pharmacist = create.pharmacist();
                    accounts.add(pharmacist);
                    ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
                    System.out.println("Register Success");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public void editAccount() {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        String username = input.inputString("username", Validate.UserName_PATTERN);
        if (!username.equals("Admin")) {
            int index = findIndexByUserName(username);
            if (index != -1) {
                if (accounts.get(index) instanceof Manager) {
                    Manager manager = create.manager();
                    Account.setCountIDAccount(Account.getCountIDAccount() - 1);
                    accounts.set(index, manager);
                    ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
                }
                if (accounts.get(index) instanceof Pharmacist) {
                    Pharmacist pharmacist = create.pharmacist();
                    Account.setCountIDAccount(Account.getCountIDAccount() - 1);
                    accounts.set(index, pharmacist);
                    ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
                }
            } else System.out.println("Not found UserName!");
        } else System.out.println("Cannot edit Admin account!");
    }

    public void deleteAccount() {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        String username = input.inputString("username", Validate.UserName_PATTERN);
        if (!username.equals("Admin")) {
            int index = findIndexByUserName(username);
            if (index != -1) {
                accounts.remove(index);
                ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
            } else System.out.println("Not found UserName!");
        } else System.out.println("Cannot delete Admin account!");
    }

    public Account findAccount(String username) {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        int index = findIndexByUserName(username);
        if (index != -1) {
            return accounts.get(index);
        }
        return null;
    }

    public void checkIn(Account account) {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(account.getUsername())) {
                index = i;
                break;
            }
        }
        if (account instanceof Pharmacist) {
            Pharmacist pharmacist = (Pharmacist) account;
            pharmacist.setDaysOn(pharmacist.getDaysOn() + 1);
            accounts.set(index, pharmacist);
            ioFile.writeDataToFile(accounts, FilePATH.Account_PATH);
        }
    }
    public void salaryPayment() {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        System.out.println("---SALARY Pharmacist---");
        System.out.printf("%-5s%-10s%-10s%-10s%-15s%s",
                "ID", "Name", "Gender", "ROLE", "SALARY", "\n");
        for (Account pharmacist : accounts) {
            if (pharmacist instanceof Pharmacist) {
                System.out.printf("%-5s%-10s%-10s%-10s%-15s%s",
                        pharmacist.getId(), pharmacist.getName(), pharmacist.getGender(), pharmacist.getROLE(),
                        ((Pharmacist)pharmacist).getToTalSalary(), "\n");
            }
        }
    }
}
