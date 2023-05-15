import java.util.Scanner;

public class ID9131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size array: ");
            size = scanner.nextInt();
            if (size <= 0) System.out.println("Error size!");
        } while (size <= 0);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Element " + i + " : ");
            array[i] = scanner.nextInt();
        }
        int min = minArray(array);
        System.out.println("Min array = " + min);
    }

    public static int minArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
}
