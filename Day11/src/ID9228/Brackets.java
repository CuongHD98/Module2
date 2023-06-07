package ID9228;

import java.util.Stack;
public class Brackets {

    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (s – c)"   ;
        System.out.println(checkBrackets(str));
    }
    public static boolean checkBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
