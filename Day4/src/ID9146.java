import java.util.Scanner;

public class ID9146 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a of ax^2 + b + c = 0 : ");
        double a = scanner.nextDouble();
        System.out.print("Enter b of ax^2 + b + c = 0 : ");
        double b = scanner.nextDouble();
        System.out.print("Enter c of ax^2 + b + c = 0 : ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double getDiscriminant = quadraticEquation.getDiscriminant();
        if (getDiscriminant > 0) {
            System.out.println(quadraticEquation.getRoot1());
            System.out.println(quadraticEquation.getRoot2());
        } else if (getDiscriminant == 0) {
            System.out.println(quadraticEquation.getRoot1());
        } else System.out.println("The equation has no roots!");
    }
}

class QuadraticEquation {
    double a, b, c;

    QuadraticEquation() {

    }

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getA() {
        return a;
    }

    double getB() {
        return b;
    }

    double getC() {
        return c;
    }

    double setA(double a) {
        return this.a = a;
    }

    double setB(double b) {
        return this.b = b;
    }

    double setC(double c) {
        return this.c = c;
    }

    double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    double getRoot1() {
        if (getDiscriminant() >= 0) return (-this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
        else return 0;
    }

    double getRoot2() {
        if (getDiscriminant() >= 0) return (-this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
        else return 0;
    }

}
