package Function;

import Manage.Validate;
import Model.Medicine;
import Model.Person;

import java.util.List;
import java.util.Scanner;

public class InputString {
    Validate validate = new Validate();
    IOFile<Medicine> ioFileM = new IOFile<>();
    IOFile<Person> ioFileP = new IOFile<>();
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

    public String inputNotDuplicated(String typeInputString, String regex, List<Object> list, String path) {
        String element;
        while (true) {
            System.out.print("Enter " + typeInputString + " : ");
            String inputString = scanner.nextLine();
            if (validate.isValidateInputString(inputString, regex)) {
                boolean isDuplicated = false;
                Object object = new Object();
                if (object instanceof Medicine) {
                    for (Object medicine : list) {
                        if (((Medicine) medicine).getNameMedicine().equals(inputString)) {
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (!isDuplicated) {
                        element = inputString;
                        return element;
                    } else System.out.println(typeInputString + " isDuplicated!");
                }
                if (object instanceof Person) {
                    for (Object person : list) {
                        if (((Person) person).getUserName().equals(inputString)) {
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (!isDuplicated) {
                        element = inputString;
                        return element;
                    } else System.out.println(typeInputString + " isDuplicated!");
                }
                return null;
            } else System.out.println("Not validate input string!");
        }
    }
}
