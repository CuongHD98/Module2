package ID9261;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size : ");
        int size = Integer.parseInt(scanner.nextLine());
        double[] list = new double[size];
        for (int i = 0; i < list.length; i++) {
            System.out.print("Enter element " + i + " : ");
            list[i] = Double.parseDouble(scanner.nextLine());
        }
        System.out.println("List : " + Arrays.toString(list));
        System.out.println("\nBegin sort processing...");
        selectionSortByStep(list);
    }


    public static void selectionSortByStep(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    double temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
            System.out.println("Swap turn " + i);
            System.out.println("List : " + Arrays.toString(list));
        }
    }


}
