import java.util.Scanner;

public class ID9134 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size students: ");
            size = scanner.nextInt();
            if (size > 30) System.out.println("Max size = 30, error!");
        } while (size > 30);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Point " + i + " = ");
            array[i] = scanner.nextInt();
        }
        int count = 0;
        System.out.print("List point : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (array[i] >= 5 && array[i] <= 10) count++;
        }
        System.out.print("\n The numbers students pass the exam is: " + count);
    }
}
