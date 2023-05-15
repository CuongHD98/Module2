import java.util.Scanner;

public class ID9108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.exit(0);
            case 1:
                System.out.println("Draw the triangle!");
                int x = sc.nextInt();
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                System.out.println("Draw the square!");
                int a = sc.nextInt();
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                System.out.println("Draw the rectangle!");
                int width = sc.nextInt();
                int height = sc.nextInt();
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            default:
                System.out.println("No choice!");
        }
    }
}
