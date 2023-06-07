package exercise;

import java.util.*;

public class MaxSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int maxLength = 0;
        String maxSubstring = "";
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                right++;
                if (set.size() > maxLength) {
                    maxLength = set.size();
                    maxSubstring = str.substring(left, right);
                }
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        System.out.println(maxSubstring);
    }
}
