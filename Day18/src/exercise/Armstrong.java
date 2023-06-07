package exercise;

import java.util.Scanner;

public class Armstrong {
    public static boolean checkArmstrong(int number) {
        int count = (int) (Math.log10(number) + 1);
        int sum = 0;
        if (number < 1) return false;
        else {
            int numberCheck = number;
            do {
                sum += Math.pow(numberCheck % 10, count);
                numberCheck /= 10;
            } while (numberCheck > 0);
            return number == sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            if (checkArmstrong(i)) System.out.println(i);
        }
    }
}
