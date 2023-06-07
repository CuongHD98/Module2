package ID9256;

import java.util.LinkedList;
import java.util.Scanner;

public class AscendingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String : ");
        String string = scanner.nextLine();
        LinkedList<Character> maxString = findMaxStringAscending(string);
        for (Character ch : maxString) {
            System.out.print(ch);
        }
        System.out.println();
    }

    static LinkedList<Character> findMaxStringAscending(String string) {
        LinkedList<Character> maxString = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > maxString.size()) {
                maxString.clear();
                maxString.addAll(list);
            }
            list.clear();
        }
        return maxString;
    }
}
