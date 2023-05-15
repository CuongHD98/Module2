import sun.security.mscapi.CPublicKey;

import java.util.Scanner;
public class ID9096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String text,text3;

        if (num < 10) {
            text = Num(num);
            System.out.println(text3);
        }
        else if (num < 20) {
            switch (num){
                case 10:
                    text3 = "Ten";
                    break;
                case 11:
                    text3 = "Eleven";
                    break;
                case 12:
                    text3 = "Twelve";
                    break;
                case 13:
                    text3 = "Thirteen";
                    break;
                case 14:
                    text3 = "Fourteen";
                    break;
                case 15:
                    text3 = "Fifteen";
                    break;
                case 16:
                    text3 = "Sixteen";
                    break;
                case 17:
                    text3 = "Seventeen";
                    break;
                case 18:
                    text3 = "Eighteen";
                    break;
                case 19:
                    text3 = "Nineteen";
                    break;
            };
            System.out.println(text3);
        }
        else if (num < 100){
            int b = num % 10;
            int a = (num - num % 10) / 10;
            if (num % 10 == 0){
                text = Num(a);
                System.out.println(text + "ty");
            }
            else {
                text = Num(a);
                text3 = Num(b);
            }
        }
    }

    public static String Num(int num) {
        String text;
        switch (num) {
            case 0:
                text = "Zero";
                break;
            case 1:
                text = "One";
                break;
            case 2:
                text = "Two";
                break;
            case 3:
                text = "Three";
                break;
            case 4:
                text = "Four";
                break;
            case 5:
                text = "Five";
                break;
            case 6:
                text = "Six";
                break;
            case 7:
                text = "Seven";
                break;
            case 8:
                text = "Eight";
                break;
            case 9:
                text = "Nine";
                break;
        };
        return text;
    }


}
