import java.util.Scanner;

public class ManageStudents {
    private Students[] students = new Students[0];
    Scanner scanner = new Scanner(System.in);

    public ManageStudents() {
    }

    public Students[] getStudents() {
        return students;
    }

    public void display() {
        System.out.println("List : ");
        for (Students s : students) {
            System.out.println("id: " + s.getId() + " name: " + s.getName() + " age: " + s.getAge());
        }
    }

    public Students creatStudent() {
        System.out.print("Enter id : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        System.out.print("Enter age : ");
        int age = Integer.parseInt(scanner.nextLine());
        return new Students(id, name, age);
    }

    public void add() {
        Students student = creatStudent();
        Students[] newStudents = new Students[students.length + 1];
        newStudents[newStudents.length - 1] = student;
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
        display();
    }

    public void edit() {
        System.out.print("Enter id edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Students s : students) {
            if (s.getId() == id) {
                System.out.print("Enter name : ");
                String name = scanner.nextLine();
                System.out.print("Enter age : ");
                int age = Integer.parseInt(scanner.nextLine());

                s.setName(name);
                s.setAge(age);
                display();
                return;
            }
        }
        System.err.println("Not found id!");
        display();
        edit();
    }

    public void delete() {
        System.out.print("Enter id delete : ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);

        if (index != -1) {
            Students[] newStudents = new Students[students.length - 1];
            for (int i = 0; i < newStudents.length; i++) {
                if (i < index) {
                    newStudents[i] = students[i];
                } else {
                    newStudents[i] = students[i + 1];
                }
            }
            students = newStudents;
            display();
        } else {
            System.err.println("Not found id!");
            display();
            delete();
        }
    }

    public void findName() {
        System.out.print("Enter name find : ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (name == students[i].getName()) {
                check = true;
                System.out.println("id " + students[i].getId() + " name " + students[i].getName() + " age " + students[i].getAge());
            }
        }
        if (!check) System.out.println("Not found name!");
    }

    public void arrangeStudents() {
        for (int i = 0; i < students.length-1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getAge() < students[j].getAge()) {
                    Students temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
