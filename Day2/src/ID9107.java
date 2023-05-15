import java.util.Scanner;

public class ID9107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a = ");
        int a = Math.abs(sc.nextInt());
        System.out.println("Enter b = ");
        int b = Math.abs(sc.nextInt());
        if (a == b) {
            if (a == 0) {
                System.out.println("Khong co UCLN!");
            } else System.out.println("UCLN = " + a);
        } else {
            if (a == 0) System.out.println("UCLN = " + b);
            else if (b == 0) System.out.println("UCLN = " + a);
        }
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        System.out.println("UCLN = " + a);
    }
}
