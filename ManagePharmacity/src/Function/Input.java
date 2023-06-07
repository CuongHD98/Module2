package Function;

import Model.Account;
import Model.Medicine;
import Model.Validate;

import java.util.List;
import java.util.Scanner;

public class Input {
    Validate validate = new Validate();
    Scanner scanner = new Scanner(System.in);

    public String inputString(String typeInputString, String regex) {
        String element;
        while (true) {
            System.out.print("Enter " + typeInputString + " : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, regex)) {
                element = inputString;
                return element;
            } else System.out.println("Not validate input string!");
        }
    }

    public int inputInt(String typeInputString, String regex) {
        int element;
        while (true) {
            System.out.print("Enter " + typeInputString + " : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, regex)) {
                element = Integer.parseInt(inputString);
                return element;
            } else System.out.println("Not validate input string!");
        }
    }

    public float inputFloat(String typeInputString, String regex) {
        float element;
        while (true) {
            System.out.print("Enter " + typeInputString + " : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, regex)) {
                element = Float.parseFloat(inputString);
                return element;
            } else System.out.println("Not validate input string!");
        }
    }

    public String inputDuplicatedUserName(List<Account> accounts) {
        String element;
        while (true) {
            System.out.print("Enter username : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, Validate.UserName_PATTERN)) {
                boolean isDuplicated = false;
                for (Account account : accounts) {
                    if (account.getUsername().equals(inputString)) {
                        isDuplicated = true;
                        break;
                    }
                }
                if (!isDuplicated) {
                    element = inputString;
                    return element;
                } else System.out.println("Username already exists!");
            } else System.out.println("Not validate input string!");
        }
    }

    public String inputDuplicatedNameMedicine(List<Medicine> medicines) {
        String element;
        while (true) {
            System.out.print("Enter nameMedicine : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, Validate.NameMedicine_PATTERN)) {
                boolean isDuplicated = false;
                for (Medicine medicine : medicines) {
                    if (medicine.getName().equals(inputString)) {
                        isDuplicated = true;
                        break;
                    }
                }
                if (!isDuplicated) {
                    element = inputString;
                    return element;
                } else System.out.println("NameMedicine already exists!");
            } else System.out.println("Not validate input string!");
        }
    }
}
