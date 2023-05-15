import java.util.Scanner;

public class ID9106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter money: ");
        int money = sc.nextInt();
        System.out.println("Enter ls: ");
        float ls = sc.nextFloat();
        System.out.println("Enter month: ");
        int month = sc.nextInt();
        double nextMoney = 0;
        for (int i = 0; i < month; i++) {
            nextMoney += money * ls / 12 * month;
        }
        System.out.println(nextMoney);

    }
}
