import java.util.Scanner;

public class ID9128 {
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
        System.out.print("Enter element add: ");
        int element = scanner.nextInt();
        System.out.print("Enter index add: ");
        int index = scanner.nextInt();
        int[] newArray = addElementArray(array, element, index);
        System.out.print("New array: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

    }

    public static int[] addElementArray(int[] array, int element, int index) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }
}
