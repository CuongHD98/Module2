package exercise;

import java.util.Scanner;

public class SumNumber {
    public static int sumNumber(int number) {
        int sum = 0;
        do {
            sum += number % 10;
            number /= 10;
        } while (number > 0);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(sumNumber(number));
    }
}
