package ID9187;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println(circle.getArea());
        circle.resize(1.5);
        System.out.println(circle);
        System.out.println(circle.getArea());;

    }
}
