import java.util.Scanner;

public class ID9123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size array: ");
        int size = scanner.nextInt();
        String[] array = new String[size];
        System.out.println("Enter element array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }
        System.out.println("Enter text find: ");
        String text = scanner.next();
        int index;
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(text)) {
                index = i;
                check = true;
                System.out.println(index);
            }
        }
        if (!check) System.out.println("Not found!");
    }
}
