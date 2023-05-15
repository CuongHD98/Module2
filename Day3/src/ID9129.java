import java.util.Scanner;
public class ID9129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size arr1: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Element arr1 " + i + " : ");
            arr1[i] = scanner.nextInt();
        }
        System.out.print("Enter size arr2: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Arr2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Element arr2 " + i + " : ");
            arr2[i] = scanner.nextInt();
        }
        int[] newArray = addArray(arr1, arr2);
        System.out.print("NewArray: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

    }
    public static int[] addArray(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            newArray[arr1.length + i] = arr2[i];
        }
        return newArray;
    }
}
