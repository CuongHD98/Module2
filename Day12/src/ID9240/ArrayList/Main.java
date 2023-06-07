package ID9240.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("Menu : ");
            System.out.println("1. Display");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. FindName");
            System.out.println("6. SortForPrice");
            System.out.println("7. Exit");
            System.out.print("Enter choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    productManager.display();
                    break;
                case "2":
                    productManager.add();
                    break;
                case "3":
                    productManager.edit();
                    break;
                case "4":
                    productManager.delete();
                    break;
                case "5":
                    productManager.findProductByName();
                    break;
                case "6":
                    productManager.sortForPrice();
                    break;
                case "7":
                    System.exit(0);
                default:
                    System.out.println("Not found Choice!");
            }


        }

    }
}
