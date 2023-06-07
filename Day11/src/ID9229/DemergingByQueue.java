package ID9229;

import java.util.LinkedList;
import java.util.Queue;

public class DemergingByQueue {
    public static void main(String[] args) {
        Queue<Student> students = new LinkedList<>();
        Queue<Student> maleStudents = new LinkedList<>();
        Queue<Student> otherStudents = new LinkedList<>();

        Queue<Student> femaleStudents = new LinkedList<>();
        for (Student student : students) {
            if (student.getGender().equals("MALE")) {
                maleStudents.offer(student);
            } else if (student.getGender().equals("FEMALE")) {
                femaleStudents.offer(student);
            } else {
                otherStudents.offer(student);
            }
        }
        System.out.println(femaleStudents);
        System.out.println(maleStudents);
        System.out.println(otherStudents);


    }
}
