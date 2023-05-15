import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageStudents manageStudents = new ManageStudents();

        while (true) {
            System.out.println("ManageStudents : ");
            System.out.println("1. Display List");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            int choice;
            boolean checkNum = false;
            do {
                System.out.print("Enter your choice : ");
                choice = Integer.parseInt(scanner.nextLine());
                int[] num = {1, 2, 3, 4, 5};
                for (int x : num) {
                    if (choice == x) {
                        checkNum = true;
                        break;
                    }
                }
                if (!checkNum) System.out.println("Not found choice!");
            } while (!checkNum);
            switch (choice) {
                case 1:
                    //Display
                    manageStudents.display();
                    break;
                case 2:
                    //Add
                    manageStudents.add();
                    break;
                case 3:
                    //Edit
                    manageStudents.edit();
                    break;
                case 4:
                    //Delete
                    manageStudents.delete();
                    break;
                case 5:
                    //Exit
                    System.exit(0);
            }

        }
    }
}