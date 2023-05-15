import java.util.Scanner;

public class ID9105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = sc.nextInt();
        boolean check = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                check = false;
                break;
            }
        }
        if (check) System.out.println(num + " la so nguyen to!");
        else System.out.println(num + " khong la so nguyen to!");
    }
}
