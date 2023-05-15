import java.util.Scanner;

public class ID9091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a of ax + b = 0 ");
        int a = sc.nextInt();
        System.out.println("Enter b if ax + b = 0 ");
        int b = sc.nextInt();
        if (a == 0) {
            if (b == 0) System.out.println("PT VSN");
            else System.out.println("PT VN");
        } else {
            float c = (float) -b / a;
            System.out.println("PT co nghiem x = " + c);
        }
    }
}
