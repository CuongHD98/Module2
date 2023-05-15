import java.util.Scanner;

public class ID9122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.println("Enter size array: ");
            size = scanner.nextInt();
            if (size > 20) System.out.println("Max size = 20, Error!");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            array[i] = scanner.nextInt();
            i++;
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[array.length - 1 - j];
            array[array.length - 1 - j] = temp;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
