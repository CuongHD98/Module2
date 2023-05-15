//import personnel.ManagePersonnel;
//
//import java.text.ParseException;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws ParseException {
//        Scanner scanner = new Scanner(System.in);
//        ManagePersonnel manageStudents = new ManagePersonnel();
//
//        while (true) {
//            System.out.println("ManagePersonnel : ");
//            System.out.println("1. Display List");
//            System.out.println("2. AddFullTime");
//            System.out.println("3. AddPartTime");
//            System.out.println("4. Payroll");
//            System.out.println("5. DeleteFullTime");
//            System.out.println("6. DeletePartTime");
//            System.out.println("7. Exit");
//            int choice;
//            boolean checkNum = false;
//            do {
//                System.out.print("Enter your choice : ");
//                choice = Integer.parseInt(scanner.nextLine());
//                int[] num = {1, 2, 3, 4, 5, 6, 7};
//                for (int x : num) {
//                    if (choice == x) {
//                        checkNum = true;
//                        break;
//                    }
//                }
//                if (!checkNum) System.out.println("Not found choice!");
//            } while (!checkNum);
//            switch (choice) {
//                case 1:
//                    //Display
//                    manageStudents.display();
//                    break;
//                case 2:
//                    //AddFullTime
//                    manageStudents.addFullTime();
//                    break;
//                case 3:
//                    //AddPartTime
//                    manageStudents.addPartTime();
//                    break;
//                case 4:
//                    //PayRoll
//                    manageStudents.displayPayRoll();
//                    break;
//                case 5:
//                    //DeleteFullTime
//                    manageStudents.deleteFullTime();
//                case 6:
//                    //DeletePartTime
//                    manageStudents.deletePartTime();
//                case 7:
//                    //Exit
//                    System.exit(0);
//            }
//
//        }
//
//
//
//    }
//}