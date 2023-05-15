package ID9186;

import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        System.out.println(circles[0].getRadius());
        System.out.println(circles[1].getRadius());
        System.out.println(circles[2].getRadius());
        System.out.println(circleComparator.compare(circles[2], circles[1]));
    }
}