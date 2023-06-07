package ID9254;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String : ");
        String string = scanner.nextLine();
        int[] asciiCount = new int[255];
        for (int i = 0; i < string.length(); i++) {
            int ascii = (int) string.charAt(i);
            asciiCount[ascii] += 1;
        }
        int count = 0;
        char ch = (char) 0;
        for (int i = 0; i < 255; i++) {
            if (asciiCount[i] > count) {
                count = asciiCount[i];
                ch = (char) i;
            }
        }
        System.out.println("char : " + ch + " count = " + count);
    }

    //T(n) = O(255);
}
