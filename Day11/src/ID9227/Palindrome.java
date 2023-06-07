package ID9227;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = scanner.nextLine();
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length() / 2; i++) {
                queue.add(str.charAt(i));
            }
            for (int i = str.length() / 2; i < str.length(); i++) {
                stack.add(str.charAt(i));
            }
        } else {
            for (int i = 0; i < str.length() / 2; i++) {
                queue.add(str.charAt(i));
            }
            for (int i = str.length() / 2 + 1; i < str.length(); i++) {
                stack.add(str.charAt(i));
            }
        }
        while (queue.size() > 1) {
            char firstString = queue.poll();
            char lastString = stack.pop();
            if (firstString != lastString) {
                return false;
            }
        }
        return true;
    }
}
