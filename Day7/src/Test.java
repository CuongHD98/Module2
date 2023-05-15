import java.util.*;
import java.lang.Object;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"A", 5));

//        Student student = new Student(1,"A",3);

        int index = 0;
        students.set(index, new Student(2,"B",5));
        System.out.println(students.get(index));
//        Calendar calendar = new GregorianCalendar(2013, 2, 1);
//        Calendar calendar1 = calendar;
//        Calendar calendar2 = (Calendar)calendar.clone();
//        System.out.println(calendar1.equals(calendar));
//        System.out.println(calendar2.equals(calendar));




//        java.util.Collections.sort(students);
//        students.forEach(e -> System.out.println(e));
//        if (students.size() > 0) {
//            int index = 0;
//            int id = Integer.parseInt(scanner.nextLine());
//
//            for (int i = 0; i < students.size(); i++) {
//                Student student = students.get(i);
//                if (student.getId() == id) index = i;
//            }
//            System.out.println(index);
//            students.remove(index);
//            students.forEach(e -> System.out.println(e));
//        } else System.exit(0);

        System.out.println(new Integer(3).compareTo(new Integer(5)));





    }
}

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int score;

    public Student(String jonh, int i) {

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
    public  int compareTo(Student o) {
        return (int) (o.getScore() - score);
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
