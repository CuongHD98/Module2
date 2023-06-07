package ID9274;

import java.util.Scanner;

public class TriangleExceptionDemo {
    private void checkTriangle(float a, float b, float c) {
        try {
            if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
                throw new IllegalTriangleException("Invalid triangle");
            } else {
                System.out.println("Valid triangle");
            }
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TriangleExceptionDemo triangleExceptionDemo = new TriangleExceptionDemo();
        System.out.print("Enter a : ");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter b : ");
        float b = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter c : ");
        float c = Float.parseFloat(scanner.nextLine());
        triangleExceptionDemo.checkTriangle(a, b, c);
    }
}

class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super();
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}

