import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageEmployee manageEmployee = new ManageEmployee();
        while (true) {
            System.out.println("Menu : ");
            System.out.println("1. Display");
            System.out.println("2. Add");
            System.out.println("3. Salary");
            System.out.println("4. CheckIn");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageEmployee.display();
                    break;
                case "2":
                    manageEmployee.addEmployee();
                    break;
                case "3":
                    manageEmployee.displaySalary();
                    break;
                case "4":
                    manageEmployee.checkIn();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }
}