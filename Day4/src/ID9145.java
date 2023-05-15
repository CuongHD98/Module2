import java.util.Scanner;

public class ID9145 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width : ");
        double width = scanner.nextDouble();
        System.out.print("Enter height : ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        double area = rectangle.getArea();
        rectangle.display(area);
    }

}

class Rectangle {
    double width;
    double height;

    Rectangle() {

    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return this.width * this.height;
    }

    double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    void display(double get) {
        System.out.println(get);
    }
}