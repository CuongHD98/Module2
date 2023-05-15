import java.util.Scanner;

public class ID9124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) System.out.println("Max size = 20, error!");
        } while (size > 20);
        long[] array = new long[size];
        System.out.println("Enter element array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLong();
        }
        long max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        System.out.println("Max = " + max);
    }
}

