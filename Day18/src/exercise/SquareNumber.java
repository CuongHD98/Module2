package exercise;

import java.util.Scanner;

public class SquareNumber {
    public static boolean checkSquareNumber(int number) {
        for (int i = 0; i < number; i++) {
            if (Math.pow(i, 2) == number) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int number = Integer.parseInt(scanner.nextLine());
        while (!checkSquareNumber(number)) {
            number--;
        }
        System.out.println(number);
    }
}
