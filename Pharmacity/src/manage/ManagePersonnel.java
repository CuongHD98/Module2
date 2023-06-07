package Manage;

import Function.Create;
import Function.IOFile;
import Function.InputString;
import Model.Manager;
import Model.Person;
import Model.Pharmacits;

import java.util.List;
import java.util.Scanner;

public class ManagePersonnel {
    public static final String Personnel_PATH = "C:\\Users\\HDC\\Desktop\\Module2\\Pharmacity\\src\\File\\Personnel.dat";
    Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();
    Create create = new Create();
    InputString inputString = new InputString();
    IOFile<Person> ioFile = new IOFile<>();

    public ManagePersonnel() {
        // check Account Admin
        List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
        boolean isHasAdminAccount = false;
        for (Person person : personList) {
            if (person.getUserName().equals("Admin")) {
                isHasAdminAccount = true;
                break;
            }
        }
        if (!isHasAdminAccount) {
            Manager manager = new Manager("Admin", "PassWord", "Admin", "Male",
                    "1/1/1111", "0123456789", "Admin@gmail.com");
            personList.add(manager);
        }
    }

    public Person login() {
        List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
        System.out.print("Enter userName : ");
        String name = scanner.nextLine();
        System.out.print("Enter passWord : ");
        String password = scanner.nextLine();
        boolean isValidateUserName = validate.isValidateInputString("userName", Validate.UserName_PATTERN);
        boolean isValidatePassWord = validate.isValidateInputString("passWord", Validate.PassWord_PATTERN);
        if (isValidateUserName && isValidatePassWord) {
            for (Person person : personList) {
                if (person.getUserName().equals(name) && person.getUserName().equals(password)) {
                    System.out.println("Login Success");
                    return person;
                } else System.out.println("Enter again!");
            }
        }
        return null;
    }

    public void register() {
        while (true) {
            List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
            System.out.println("Menu Register : ");
            System.out.println("1. Register Manager");
            System.out.println("2. Register Pharmacist");
            System.out.println("3. Exit Register");
            System.out.println("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Manager manager = create.createManager(Personnel_PATH);
                    personList.add(manager);
                    System.out.println("Register Success");
                    break;
                case "2":
                    Pharmacits pharmacits = create.createPharmacist(Personnel_PATH);
                    personList.add(pharmacits);
                    System.out.println("Register Success");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public void displayPersonnel() {
        List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
        for (Person person : personList) {
            if (person instanceof Manager) {
                person = (Manager) person;
                System.out.println(person);
            }
            if (person instanceof Pharmacits) {
                person = (Pharmacits) person;
                System.out.println(person);
            }
        }
    }

    public void addPersonnel() {
        while (true) {
            List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
            System.out.println("Menu AddPersonnel : ");
            System.out.println("1. Manager");
            System.out.println("2. Pharmacist");
            System.out.println("3. ExitAdd");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Manager manager = create.createManager(Personnel_PATH);
                    personList.add(manager);
                    break;
                case "2":
                    Pharmacits pharmacits = create.createPharmacist(Personnel_PATH);
                    personList.add(pharmacits);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public int findIndexByUserName(String userName) {
        List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getUserName().equals(userName)) return i;
        }
        return -1;
    }

    public void editPersonnel() {
        while (true) {
            List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
            System.out.print("Enter userName : ");
            String userName = inputString.inputString("userName", Validate.UserName_PATTERN);
            if (userName.equals("Admin")) System.out.println("Can't edit Admin account!");
            else {
                int index = findIndexByUserName(userName);
                if (index != -1) {
                    if (personList.get(index) instanceof Manager) {
                        Manager manager = create.createManager(Personnel_PATH);
                        manager.setId(personList.get(index).getId());
                        personList.set(index, manager);
                        break;
                    }
                    if (personList.get(index) instanceof Pharmacits) {
                        Pharmacits pharmacits = create.createPharmacist(Personnel_PATH);
                        pharmacits.setId(personList.get(index).getId());
                        personList.set(index, pharmacits);
                        break;
                    }
                } else System.out.println("Not found UserName!");
            }
        }
    }

    public void deletePersonnel() {
        while (true) {
            List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
            System.out.print("Enter userName : ");
            String userName = inputString.inputString("userName", Validate.UserName_PATTERN);
            if (userName.equals("Admin")) System.out.println("Can't delete Admin account!");
            else {
                int index = findIndexByUserName(userName);
                if (index != -1) {
                    personList.remove(index);
                    break;
                } else System.out.println("Not found UserName!");
            }
        }
    }

    public void checkInOut(Pharmacits pharmacits) {
        while (true) {
            List<Person> personList = ioFile.readDataFromFile(Personnel_PATH);
            int index = findIndexByUserName(pharmacits.getUserName());
            System.out.println("Menu CheckIn : ");
            System.out.println("1. On time");
            System.out.println("2. CheckInLate");
            System.out.println("3. CheckOutSoon");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    pharmacits.setDaysOn(pharmacits.getDaysOn() + 1);
                    personList.set(index, pharmacits);
                    ioFile.writeDataToFile(personList, Personnel_PATH);
                    break;
                case "2":
                    pharmacits.setTimesCheckInLate(pharmacits.getTimesCheckInLate() + 1);
                    personList.set(index, pharmacits);
                    ioFile.writeDataToFile(personList, Personnel_PATH);
                    break;
                case "3":
                    pharmacits.setTimesCheckOutSoon(pharmacits.getTimesCheckOutSoon() + 1);
                    personList.set(index, pharmacits);
                    ioFile.writeDataToFile(personList, Personnel_PATH);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}
