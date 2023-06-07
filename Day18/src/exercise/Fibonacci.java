package exercise;

import java.util.Scanner;

public class Fibonacci {
    public static boolean checkFibonacci(int[] numbers) {
        if (numbers.length > 2) {
            if (numbers[0] == 1 && numbers[1] == 1) {
                for (int i = 2; i < numbers.length; i++) {
                    if (numbers[i] != numbers[i - 1] + numbers[i - 2]) return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size numbers : ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers[i] = number;
        }
        System.out.println(checkFibonacci(numbers));
    }
}
