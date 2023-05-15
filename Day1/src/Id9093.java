import java.util.Scanner;

public class ID9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Year: ");
        int y = sc.nextInt();
        boolean check = false;
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) check = true;
            } else check = true;
        }
        if (check) System.out.println(y + " la nam nhuan!");
        else System.out.println(y + " khong la nam nhuan!");
    }
}
