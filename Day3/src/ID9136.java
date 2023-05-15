import java.util.Scanner;

public class ID9136 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Enter string : ");
        str = scanner.next();
        System.out.println("String : " + str);
        char ch;
        System.out.print("Enter char find : ");
        ch = scanner.next().charAt(0);
        int count = timesFindElementString(str, ch);
        System.out.println("Times find " + ch + " of string = " + count);
    }

    public static int timesFindElementString(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) count++;
        }
        return count;
    }
}
