package ID9226;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimalNumber = 25;
        Stack<Integer> stack = new Stack<Integer>();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }






}
