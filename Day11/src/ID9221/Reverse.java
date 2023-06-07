package ID9221;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.print("Enter Choice : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.print("Enter size Integer : ");
                int sizeInteger = Integer.parseInt(scanner.nextLine());
                Stack<Integer> numbers = new Stack<>();
                for (int i = 0; i < sizeInteger; i++) {
                    System.out.print("Enter element : ");
                    int number = Integer.parseInt(scanner.nextLine());
                    numbers.push(number);
                }
                while (!numbers.isEmpty()) {
                    System.out.print(numbers.pop() + " ");
                }
                break;
            case 2:
                System.out.print("Enter String : ");
                String string = scanner.nextLine();
                Stack<Character> characters = new Stack<>();
                for (int i = 0; i < string.length(); i++) {
                    characters.push(string.charAt(i));
                }
                while (!characters.isEmpty()) {
                    System.out.print(characters.pop());
                }
                break;
            default:
                System.exit(0);
        }
    }
}
