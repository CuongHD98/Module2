package personnel;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class ManagePersonnel {
    private ArrayList<Personnel> personnel = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ManagePersonnel() {
    }

    public ArrayList<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(ArrayList<Personnel> personnel) {
        this.personnel = personnel;
    }

    public void display() {
        System.out.println("List Personnel : ");
        personnel.forEach(p -> System.out.println(p));
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
        Personnel.count--;
        return new Personnel(name, phone, birthday);
    }

    public FullTime creatFullTime() throws ParseException {
        Personnel personnel = creatPersonnel();
        System.out.print("Enter Coefficient : ");
        float coefficient = Float.parseFloat(scanner.nextLine());
        return new FullTime(personnel.getName(), personnel.getPhone(), personnel.getBirthday(), coefficient);
    }

    public PartTime creatPartTime() throws ParseException {
        Personnel personnel = creatPersonnel();
        System.out.print("Enter TimeWork : ");
        int timeWork = Integer.parseInt(scanner.nextLine());
        return new PartTime(personnel.getName(), personnel.getPhone(), personnel.getBirthday(), timeWork);
    }

    public void add() throws ParseException {
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        System.out.print("Enter Choice : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                FullTime fullTime = creatFullTime();
                personnel.add(fullTime);
                break;
            case 2:
                PartTime partTime = creatPartTime();
                personnel.add(partTime);
                break;
            default:
                System.err.println("Not found Choice, Try again!");
        }
    }

    public void edit() throws ParseException {
        System.out.print("Enter ID edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        String check = findIndexById(id);
        int index = 0;
        if (check == "FullTime") {
            FullTime fullTime = creatFullTime();
            resetID();
            fullTime.setId(id);
            for (int i = 0; i < personnel.size(); i++) {
                if (personnel.get(i).getId() == id) index = i;
            }
            personnel.set(index, fullTime);
        } else if (check == "PartTime") {
            PartTime partTime = creatPartTime();
            resetID();
            partTime.setId(id);
            for (int i = 0; i < personnel.size(); i++) {
                if (personnel.get(i).getId() == id) index = i;
            }
            personnel.set(index, partTime);
        } else {
            System.err.println("Not found ID!");
            edit();
        }
    }

    public void delete() {
        System.out.print("Enter ID edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        String check = findIndexById(id);
        int index = 0;
        String checkD = findIndexById(id);
        if (check != "-1") {
            for (int i = 0; i < personnel.size(); i++) {
                if (personnel.get(i).getId() == id) index = i;
            }
            personnel.remove(index);
        } else {
            System.err.println("Not found ID!");
            delete();
        }
    }

    public String findIndexById(int id) {
        for (Personnel p : personnel) {
            if (p.getId() == id) return p.getTypeWork();
        }
        return "-1";
    }

    public void findNamePersonnel() {
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        boolean check = false;
        for (Personnel p : personnel) {
            if (p.getName().equals(name)) {
                check = true;
                System.out.println(p);
            }
        }
        if (!check) {
            System.err.println("Not found Name!");
            findNamePersonnel();
        }
    }

    public void payRoll() {
        System.out.println("List Personnel : ");
        personnel.forEach(p -> {
            System.out.println(p);
            ;
            System.out.println("Money : " + p.workMoney());
        });
    }

    public void resetID() {
        Collections.sort(personnel);
        Personnel.count = personnel.get(personnel.size() - 1).getId();
        Personnel.count++;
    }

    public void sort() {
        System.out.println("1. Sort ID");
        System.out.println("2. Sort Name");
        System.out.println("3. Sort Phone");
        System.out.println("4. Sort Birthday");
        System.out.print("Enter Choice : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                Collections.sort(personnel);
                display();
                break;
            case 2:
                Collections.sort(personnel, new Comparator<Personnel>() {
                    @Override
                    public int compare(Personnel o1, Personnel o2) {
                        if (o1.getName().compareTo(o2.getName()) == 0) {
                            return o1.getId() - o2.getId();
                        } else return o1.getName().compareTo(o2.getName());
                    }
                });
                display();
                break;
            case 3:
                Collections.sort(personnel, new Comparator<Personnel>() {
                    @Override
                    public int compare(Personnel o1, Personnel o2) {
                        if (o1.getPhone().compareTo(o2.getPhone()) == 0) {
                            return o1.getId() - o2.getId();
                        } else return o1.getPhone().compareTo(o2.getPhone());
                    }
                });
                display();
                break;
            case 4:
                Collections.sort(personnel, new Comparator<Personnel>() {
                    @Override
                    public int compare(Personnel o1, Personnel o2) {
                        if (o1.getBirthday().compareTo(o2.getBirthday()) == 0) {
                            return o1.getId() - o2.getId();
                        } else return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                });
                display();
                break;
            default:
                System.err.println("Not found Choice, Try again!");
        }
    }


}
