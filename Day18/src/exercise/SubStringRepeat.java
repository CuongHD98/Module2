package exercise;

import java.util.HashMap;
import java.util.Scanner;

public class SubStringRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String : ");
        String input = scanner.nextLine();

        String longestRepeatingSubstring = findLongestRepeatingSubstring(input);
        System.out.println("MaxSubString: " + longestRepeatingSubstring);
    }

    public static String findLongestRepeatingSubstring(String input) {
        int n = input.length();
        int[][] dp = new int[n + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (input.charAt(i - 1) == input.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }

        if (maxLength > 0) {
            return input.substring(endIndex - maxLength + 1, endIndex + 1);
        } else {
            return "";
        }
    }
}