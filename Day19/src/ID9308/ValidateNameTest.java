package ID9308;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameTest {
    private static ValidateName validateName;
    public static final String[] validName = new String[]{"C0223G", "A0323K"};
    public static final String[] invalidName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        validateName = new ValidateName();
        for (String name : validName) {
            boolean isValid = validateName.validate(name);
            System.out.println(name + " " + isValid);
        }
        for (String name : invalidName) {
            boolean isValid = validateName.validate(name);
            System.out.println(name + " " + isValid);
        }
    }


}


class ValidateName {
    private static final String NAME_REGEX = "^[CAP]\\d{4}[GHIK]$";

    public ValidateName() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}