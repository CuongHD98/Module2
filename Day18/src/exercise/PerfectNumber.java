package exercise;

import java.util.Scanner;

public class PerfectNumber {
    public static boolean checkPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return number == sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int number = Integer.parseInt(scanner.nextLine());
        while (!checkPerfectNumber(number)) {
            number++;
        }
        System.out.println(number);
    }
}
