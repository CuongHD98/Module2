import personnel.ManagePersonnel;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ManagePersonnel manageStudents = new ManagePersonnel();

        while (true) {
            System.out.println("ManagePersonnel : ");
            System.out.println("1. Display List");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. PayRoll");
            System.out.println("6. Sort");
            System.out.println("7. FindName");
            System.out.println("8. Exit");
            int choice;
            boolean checkNum = false;
            do {
                System.out.print("Enter your choice : ");
                choice = Integer.parseInt(scanner.nextLine());
                int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
                for (int x : num) {
                    if (choice == x) {
                        checkNum = true;
                        break;
                    }
                }
                if (!checkNum) System.out.println("Not found Choice, Try again!");
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
                    //PayRoll
                    manageStudents.payRoll();
                    break;
                case 6:
                    //Sort
                    manageStudents.sort();
                    break;
                case 7:
                    //FindName
                    manageStudents.findNamePersonnel();
                    break;
                case 8:
                    //Exit
                    System.exit(0);
            }

        }
    }
}