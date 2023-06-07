package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            String string = scanner.nextLine();
            strings[i] = string;
        }
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
