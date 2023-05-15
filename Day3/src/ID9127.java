import java.util.Scanner;

public class ID9127 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size array: ");
            size = scanner.nextInt();
            if (size <= 0) System.out.println("Error!");
        } while (size <= 0);
        System.out.println("Enter element array: ");
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Element " + i + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter element delete: ");
        int element = scanner.nextInt();
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                check = true;
                break;
            }
        }
        if (check) {
            int[] newArray = deleteElementArray(array, element);
            System.out.print("NewArray : ");
            for (int j = 0; j < newArray.length; j++) {
                System.out.print(newArray[j] + " ");
            }
        } else System.out.println("Not found element!");

    }

    public static int[] deleteElementArray(int[] array, int element) {
        int[] newArray = new int[array.length - 1];
        int index;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                index = i;
                for (int j = 0; j < index; j++) {
                    newArray[j] = array[j];
                }
                for (int j = index; j < newArray.length; j++) {
                    newArray[j] = array[j + 1];
                }
            }
        }
        return newArray;
    }
}
