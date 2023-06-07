package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        else {
            List<Character> char1 = new ArrayList<>();
            List<Character> char2 = new ArrayList<>();
            for (int i = 0; i < str1.length(); i++) {
                char1.add(str1.charAt(i));
                char2.add(str2.charAt(i));
            }
            Collections.sort(char1);
            Collections.sort(char2);
            for (int i = 0; i < char1.size(); i++) {
                if (char1.get(i) != char2.get(i)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(isAnagram(str1, str2));
    }

}
