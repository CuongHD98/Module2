package ID9255;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size : ");
            size = Integer.parseInt(scanner.nextLine());
            if (size < 0) System.out.println("Error size!");
        } while (size < 0);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(arr);
        System.out.print("Enter value find : ");
        int value = Integer.parseInt(scanner.nextLine());
        int index = binarySearch(arr, 0, arr.length - 1, value);
        if (index != -1) System.out.println("Arrays has value = " + value);
        else System.out.println("Not found value!");
    }

    static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (array[middle] == value) return middle;
            else if (array[middle] > value) return binarySearch(array, left, middle - 1, value);
            else return binarySearch(array, middle + 1, right, value);
        }
        return -1;
    }
}
