import java.util.Scanner;

public class ID9097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your money USD: ");
        int u = sc.nextInt();
        float v = (float) u * 23000;
        System.out.println("Your money VND: " + v);
    }
}
