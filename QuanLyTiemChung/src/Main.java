import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageCustomer manageCustomer = new ManageCustomer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("Menu : ");
            System.out.println("1. Display");
            System.out.println("2. AddCustomer");
            System.out.println("3. AddVaccine");
            System.out.println("4. Exit");
            System.out.print("Enter choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageCustomer.display();
                    break;
                case "2":
                    manageCustomer.addCustomer();
                    break;
                case "3":
                    manageCustomer.addVaccineByName();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}