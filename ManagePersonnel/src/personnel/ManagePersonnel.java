package personnel;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class ManagePersonnel {
    private FullTime[] fullTimes = new FullTime[0];
    private PartTime[] partTimes = new PartTime[0];
    Scanner scanner = new Scanner(System.in);

    public ManagePersonnel() {
    }

    public void display() {
        System.out.println("List Personnel : ");
        for (FullTime f : fullTimes) {
            f.toString();
        }
        for (PartTime p : partTimes) {
            p.toString();
        }
    }

    public Personnel creatPersonnel() throws ParseException {
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone : ");
        String phone = scanner.nextLine();
        System.out.print("Enter Birthday : ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String input = scanner.nextLine();
        Date birthday = dateFormat.parse(input);
        return new Personnel(name, phone, birthday);
    }

    public void add() throws ParseException {
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        int choice;
        boolean checkNum = false;
        do {
            System.out.print("Enter Choice : ");
            choice = Integer.parseInt(scanner.nextLine());
            int[] num = {1, 2};
            for (int x : num) {
                if (choice == x) {
                    checkNum = true;
                    break;
                }
            }
            if (!checkNum) System.out.println("Not found Choice!");
        } while (!checkNum);
        switch (choice) {
            case 1:
                Personnel personnel1 = creatPersonnel();
                System.out.print("Enter Coefficient : ");
                float coefficient = Float.parseFloat(scanner.nextLine());
                FullTime fullTime = new FullTime(personnel1.getName(), personnel1.getPhone(), personnel1.getBirthday(), coefficient);
                FullTime[] newFullTimes = new FullTime[fullTimes.length + 1];
                newFullTimes[newFullTimes.length - 1] = fullTime;
                for (int i = 0; i < fullTimes.length; i++) {
                    newFullTimes[i] = fullTimes[i];
                }
                fullTimes = newFullTimes;
            case 2:
                Personnel personnel2 = creatPersonnel();
                System.out.println();
                System.out.print("Enter TimeWork : ");
                int timeWork = Integer.parseInt(scanner.nextLine());
                PartTime partTime = new PartTime(personnel2.getName(), personnel2.getPhone(), personnel2.getBirthday(), timeWork);
                PartTime[] newPartTimes = new PartTime[partTimes.length + 1];
                newPartTimes[newPartTimes.length - 1] = partTime;
                for (int i = 0; i < partTimes.length; i++) {
                    newPartTimes[i] = partTimes[i];
                }
                partTimes = newPartTimes;
        }
    }

    public void edit() throws ParseException {
        System.out.print("Enter ID edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < fullTimes.length; i++) {
            if (fullTimes[i].getId() == id) {
                Personnel personnel = creatPersonnel();
                System.out.print("Enter Coefficient : ");
                float coefficient = Integer.parseInt(scanner.nextLine());
                FullTime fullTime = new FullTime(personnel.getName(), personnel.getPhone(), personnel.getBirthday(), coefficient);
                fullTimes[i] = fullTime;
                return;
            }
        }
        for (int i = 0; i < partTimes.length; i++) {
            if (partTimes[i].getId() == id) {
                Personnel personnel = creatPersonnel();
                System.out.print("Enter TimeWork : ");
                int timeWork = Integer.parseInt(scanner.nextLine());
                PartTime partTime = new PartTime(personnel.getName(), personnel.getPhone(), personnel.getBirthday(), timeWork);
                partTimes[i] = partTime;
                return;
            }
        }
        System.err.println("Not found ID!");
        edit();
    }

    public void delete() {
        System.out.print("Enter ID edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        String text = findIndexById(id);
        int index = 0;
        if (text == "f") {
            for (int i = 0; i < fullTimes.length; i++) {
                if (fullTimes[i].getId() == id) index = i;
            }
            FullTime[] newFullTimes = new FullTime[fullTimes.length - 1];
            for (int i = 0; i < newFullTimes.length; i++) {
                if (i < index) newFullTimes[i] = fullTimes[i];
                else newFullTimes[i] = fullTimes[i + 1];
            }
            fullTimes = newFullTimes;
        } else if (text == "p") {
            for (int i = 0; i < partTimes.length; i++) {
                if (partTimes[i].getId() == id) index = i;
            }
            PartTime[] newPartTimes = new PartTime[partTimes.length - 1];
            for (int i = 0; i < newPartTimes.length; i++) {
                if (i < index) newPartTimes[i] = partTimes[i];
                else newPartTimes[i] = partTimes[i + 1];
            }
            partTimes = newPartTimes;
        } else {
            System.err.println("Not found ID!");
            delete();
        }
    }

    public String findIndexById(int id) {
        for (int i = 0; i < fullTimes.length; i++) {
            if (fullTimes[i].getId() == id) {
                return "f";
            }
        }
        for (int i = 0; i < partTimes.length; i++) {
            if (partTimes[i].getId() == id) {
                return "p";
            }
        }
        return "-1";
    }

    public void findNamePersonnel() {
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < fullTimes.length; i++) {
            if (fullTimes[i].getName() == name) {
                check = true;
                fullTimes[i].toString();
            }
        }
        for (int i = 0; i < partTimes.length; i++) {
            if (partTimes[i].getName() == name) {
                check = true;
                partTimes[i].toString();
            }
        }
        if (!check) {
            System.err.println("Not found Name!");
            findNamePersonnel();
        }
    }

    public void displayPayRoll() {
        System.out.println("List Personnel : ");
        for (FullTime f : fullTimes) {
            f.toString();
            System.out.println(f.workMoney());
        }
        for (PartTime p : partTimes) {
            p.toString();
            System.out.println(p.workMoney());
        }
    }




//
//    public void display() {
//        System.out.println("Full Time:");
//        fullTimes.forEach(e -> System.out.println(e));
//        System.out.println("Part Time:");
//        partTimes.forEach(e -> System.out.println(e));
//    }
//
//    public FullTime creatFulltime() throws ParseException {
//        System.out.print("Enter Name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter Phone: ");
//        String phone = scanner.nextLine();
//
//        System.out.print("Enter Birthday: ");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String input = scanner.nextLine();
//        Date date = dateFormat.parse(input);
//
//        System.out.print("Enter Coefficient: ");
//        float coefficient = Float.parseFloat(scanner.nextLine());
//
//        return new FullTime(name, phone, date, coefficient);
//    }
//
//    public PartTime creatParttime() throws ParseException {
//        System.out.print("Enter Name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter Phone: ");
//        String phone = scanner.nextLine();
//
//        System.out.print("Enter Birthday: ");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String input = scanner.nextLine();
//        Date date = dateFormat.parse(input);
//
//        System.out.print("Enter TimeWork: ");
//        int timeWork = Integer.parseInt(scanner.nextLine());
//
//        return new PartTime(name, phone, date, timeWork);
//    }
//
//    public void addFullTime() throws ParseException {
//        FullTime fullTime = creatFulltime();
//        fullTimes.add(fullTime);
//    }
//
//    public void addPartTime() throws ParseException {
//        PartTime partTime = creatParttime();
//        partTimes.add(partTime);
//    }
//
//    public void displayPayRoll() {
//        for (FullTime f: fullTimes) {
//            System.out.println(f);
//            System.out.println(f.workMoney());
//        }
//        for (PartTime p: partTimes) {
//            System.out.println(p);
//            System.out.println(p.workMoney());
//        }
//
//    }
//
//    public void deletePartTime() {
//        System.out.print("Enter id delete : ");
//        int id = Integer.parseInt(scanner.nextLine());
//        int index = 0;
//        for (int i = 0; i < partTimes.size(); i++) {
//            PartTime partTime = partTimes.get(i);
//            if (partTime.getId() == id) index = i;
//        }
//        partTimes.remove(index);
//    }
//
//    public void deleteFullTime() {
//        if (fullTimes.size() > 0) {
//            System.out.print("Enter id delete : ");
//            int id = Integer.parseInt(scanner.nextLine());
//            int index = 0;
//            for (int i = 0; i < fullTimes.size(); i++) {
//                FullTime fullTime = fullTimes.get(i);
//                if (fullTime.getId() == id) index = i;
//            }
//            partTimes.remove(index);
//        } else System.exit(0);
//
//    }


}
