package exercise;

import java.util.Scanner;

public class PrimeNumber {
    public static boolean checkPrimeNumber(int number) {
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) return false;
            }
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size numbers : ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers[i] = number;
        }
        int primeNumber = 0;
        for (Integer number : numbers) {
            if (checkPrimeNumber(number) && number > primeNumber) primeNumber = number;
        }
        if (primeNumber != 0) System.out.println(primeNumber);
        else System.out.println("Numbers has not PrimeNumber!");
    }
}
