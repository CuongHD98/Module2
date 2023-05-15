import java.util.Scanner;

public class ID9092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month: ");
        byte m = sc.nextByte();
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang " + m + " co 31 ngay!");
                break;
            case 2:
                System.out.println("Thang 2 co 28 hoac 29 ngay!");
                break;
            default:
                System.out.println("Thang " + m + " co 30 ngay!");
        }
    }
}
