import java.util.ArrayList;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String string = "abc";
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            characters.push(string.charAt(i));
        }
        for (Character c : characters) {
            System.out.println(c);
        }

    }
}