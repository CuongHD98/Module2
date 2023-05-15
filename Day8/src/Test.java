import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentArraysList = new ArrayList<>();
        studentArraysList.add(new Student(1,"A",3));
        studentArraysList.add(new Student(2,"B",3));
        System.out.println(studentArraysList);
        int index = -1;
        System.out.println(index);
        int id = Integer.parseInt(scanner.nextLine());
        while (studentArraysList.size() > 0) {
            for (int i = 0; i < studentArraysList.size(); i++) {
                if (studentArraysList.get(i).getId() == id) index = i;
            }
            if (index != -1) studentArraysList.remove(index);
        }

        System.out.println(studentArraysList);


    }
}


class Student {
    private int id;
    private String name;
    private int score;

    public Student() {
    }

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}